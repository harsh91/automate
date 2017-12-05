package oxyzo.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import org.testng.annotations.Test;

/**
 * Created by nitika on 24/11/17.
 */
public class LoanApplicationCreate {
    public ValidatableResponse vResponse =null;
    public Response responseCreateApp =null;
    String loanAppId="";

    //Before Suite
    @BeforeSuite
    public void turnOffTestNgListeners() {

        TestNG myTestNG = new TestNG();
        myTestNG.setUseDefaultListeners(true);
        System.out.println("which option to select: \n 1. loan application with no sales assignee \n 2. loan "
            + "application with sales assignee \n 3. loan application status - processing \n 4. loan application"
            + "status - underwriting \n 5. loan application status - sent_to_nbfc \n 6. loan application status - "
            + "offered status \n 7.loan application in accepted status i.e loan with loan-id and with status - "
            + "waiting_for_docs");

    }

    public String loanApp()
    {
        vResponse =
            given().
                contentType("application/json").
                header("X-OFB-TOKEN", "6331308580062367961").
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/newApp/newApp.vm")).

                when().
                put("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/admin/loanApplication").

                then();
        responseCreateApp=
            vResponse.log().ifError().
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).
                log().ifError().

                extract().
                response();
        loanAppId= responseCreateApp.jsonPath().getString("data.applicationId");
        return loanAppId;
    }
}
