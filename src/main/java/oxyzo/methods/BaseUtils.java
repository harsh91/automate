package oxyzo.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 05/12/17.
 */
public class BaseUtils {

    String strLoanAppId=null;
    String strLoanId=null;

    //Before Suite
    @BeforeSuite
    public void turnOffTestNgListeners() {

        TestNG myTestNG = new TestNG();
        myTestNG.setUseDefaultListeners(true);
    }

    public void findLoanApplication()
    {
        Integer numbLoan =0;
        String str = null;
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", "6340461937448460011").//change this nitika

                when().
                get("/api/v1/oxyzo/admin/loanApplications?pageNumber=0&query=9654997632&filter=STATUS:ALL").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
        str=context.response.jsonPath().getString("data.content.size()");

        numbLoan = Integer.parseInt(str);
        System.out.println("number Loan Application------"+ numbLoan);
        for(int i = 0;i<numbLoan;i++)
        {
            strLoanAppId =context.response.jsonPath().getString("data.content["+i+"].applicationId");
            System.out.println("Loan id abandoned: "+ strLoanAppId);
            loanAppStatusAbandoned(strLoanAppId);
            loanAppStatusDeleted(strLoanAppId);
        }
    }

    public void findLoan()
    {
        Integer numbLoan =0;
        String str = null;
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", "6340461937448460011").//change this nitika

                when().
                get("/api/v1/oxyzo/admin/loans?query=&filter=ASSOCIATE_ACCOUNT_ID:6076953799463800943").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
        str=context.response.jsonPath().getString("data.content.size()");

        numbLoan = Integer.parseInt(str);
        System.out.println("numbLoan------"+ numbLoan);
        for(int i = 0;i<numbLoan;i++)
        {
            strLoanId =context.response.jsonPath().getString("data.content["+i+"].loanApplicationId");
            System.out.println("Loan id abandoned: "+ strLoanAppId);
            loanStatusAbandoned(strLoanId);

        }
    }

    public void loanAppStatusAbandoned(String strLoanAppId)
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", "6340461937448460011").//change this nitika
                body(VelocityTemplateFactory.convertTemplateToString
                ("src/main/resources/template/login/loanStatus.vm")).
                when().
                post("/api/v1/oxyzo/internal/loanApplication/"+strLoanAppId+"/status/ABANDONED").

                then();

    }

    public void loanAppStatusDeleted(String strLoanAppId)
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", "6340461937448460011").//change this nitika
                when().
                put("/api/v1/oxyzo/internal/changeDeletionStatus?entityType=LOAN_APPLICATION&entityId"
                        + "="+strLoanAppId+"&isDeleteRequest=true").
                then();

    }

    public void loanStatusAbandoned(String strLoanId)
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", "6340461937448460011").//change this nitika
                body(VelocityTemplateFactory.convertTemplateToString
                ("src/main/resources/template/login/loanStatus.vm")).
                when().
                post("/api/v1/oxyzo/internal/loan/"+strLoanId+"/status/ABANDONED").

                then();

    }


    @BeforeSuite(groups = {"1","2","3","4","5","6","7","8"})
    public void turnOffTestNgListener() {

        TestNG myTestNG = new TestNG();
        myTestNG.setUseDefaultListeners(true);
        System.out.println("which option to select: \n 1. loan application with no sales assignee \n 2. loan "
            + "application with sales assignee \n 3. loan application status - processing \n 4. loan application"
            + "status - underwriting \n 5. loan application status - sent_to_nbfc \n 6. loan application status - "
            + "offered status \n 7.loan application in accepted status i.e loan with loan-id and with status - "
            + "waiting_for_docs");
        findLoanApplication();
        findLoan();
    }
    private static final Context context = Context.getInstance();

    @BeforeSuite(groups = {"1","2","3","4","5","6","7","8"})
    public void setURL() {
        // Setup data
        setupData();
        RestAssured.baseURI = context.getBaseURI();
        System.out.println("base");
    }

    public void setupData() {
        try {
            // Setup Data
            context.setProperties(PropertiesLoaderUtils.loadProperties(context.getResource()));
            context.setBaseURI(context.getProperties().getProperty("baseURI"));
            context.setApiURI(context.getProperties().getProperty("apiURI"));
            System.out.println(context.getProperties().getProperty("baseURI"));
        }
           catch (Exception e)
        {
            throw new IllegalStateException("exception", e);
        }
    }

    public void fetchAccIdFromToken() {
        try {
            context.vResponse=
                given().log().all().
                    contentType("application/json").
                    header("X-OFB-TOKEN", context.getAuthToken()).

                    when().
                    get("/api/v1/account/detail").

                    then();
            Response responseOfAccountDetail= context.vResponse.log().ifError().
                assertThat().body("success", Matchers.equalTo(true)).
                assertThat().body("errorMessage", Matchers.equalTo(null)).

                extract().
                response();

            String testAccountID = responseOfAccountDetail.jsonPath().getString("data.account.accountId");
            context.setTestAccountID(testAccountID);
            System.out.print("Account: "+context.getTestAccountID());
        }
        catch (Exception e)
        {
            String errorResponseBody = context.vResponse.extract().response().print();
            String errorMessage = null;
            try {
                JSONObject jsonObject = new JSONObject(errorResponseBody);
                errorMessage = jsonObject.getString("errorMessage");
            } catch (JSONException e1) {
                //ignore
            }
            throw new RuntimeException(e);
        }
    }

    public void testCreateAutomationAccount() {
        try {
            context.vResponse=
                given().log().all().
                    contentType("text/html").

                    when().
                    put("/api/v1/automationBot/account").

                    then();
            context.response=context.vResponse.log().ifError().
                assertThat().statusCode(Matchers.equalTo(200)).
                extract().
                response();

            context.setTestAccountID("data.accountId");
        }
        catch (Exception e)
        {
            String errorResponseBody = context.vResponse.extract().response().print();
            String errorMessage = null;
            try {
                JSONObject jsonObject = new JSONObject(errorResponseBody);
                errorMessage = jsonObject.getString("errorMessage");
            } catch (JSONException e1) {
                //ignore
            }
        }
    }
}
