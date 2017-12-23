package oxyzo.methods;

import org.hamcrest.Matchers;
import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 12/12/17.
 *  5- loan_app_status-sent_to_nbfc \n
 */
public class LoanAppCreate_5 extends BaseUtils{
    private static final Context context = Context.getInstance();
    public void fillUvObservation()
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString
                    ("src/main/resources/template/test_3/uvObservation.vm")).

                when().
                post("/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId() +"/uwobservations").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
    }
    public void CompareObservation()
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString
                    ("src/main/resources/template/test_3/compareObservation.vm")).

                when().
                post("/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId()
                    +"/pdform?creatorType=UNDERWRITER").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
    }
    public void LoanRequest()
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString
                    ("src/main/resources/template/test_5/loanRequest.vm")).

                when().
                put("/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId()
                    +"/loanRequests").

                then();
        context.response=
            context.vResponse.
                assertThat().statusCode(200).
                extract().
                response();
        context.setLoanRequestId(context.response.jsonPath().getString("data.loanRequests[0].loanRequestId"));
    }
    public void saveScoreCard()
    {
        context.setLoanAppId("6343277533672250560");
        context.setAuthToken("6340461937448460011");
        for(int i=1 ; i<10;i++) {
            String strBody = "src/main/resources/template/test_5/scoreCard_"+i+".vm";

            context.vResponse =
                given().log().all().
                    contentType("application/json").
                    header("X-OFB-TOKEN", context.getAuthToken()).
                    body(VelocityTemplateFactory.convertTemplateToString
                        (strBody)).

                    when().
                    post("/api/v1/oxyzo/admin/loanApplication/" + context.getLoanAppId()
                        + "/scorecard").

                    then();
            context.response =
                context.vResponse.
                        assertThat().statusCode(Matchers.equalTo(200)).
                        extract().
                        response();
        }
    }
}
