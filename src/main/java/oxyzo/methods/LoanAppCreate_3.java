package oxyzo.methods;

import oxyzo.utils.Context;
import org.hamcrest.Matchers;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 25/11/17.
 * 3- loan_app_status-processing
 */
public class LoanAppCreate_3 extends BaseUtils {

    private static final Context context = Context.getInstance();

    public void loanAppUpdate()
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/test_3/updateApp"
                    + ".vm")).

                when().
                patch("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/admin/loanApplication").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).
                assertThat().statusCode(Matchers.equalTo(200)).

                extract().
                response();
        System.out.println("client verified now for further loan application process");

    }

    public void loanAppVerifiedCust()
    {
        context.setAuthToken("6338559818789297767"); //change this nitika
        System.out.println("auth token: "+ context.getAuthToken());
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/test_3/verifiedCust.vm")).

                when().
                patch("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/admin/loanApplication").

                then();
        context.response=
            context.vResponse.
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
    }

    public void loanAppStatusUpdate(String strStatus)
    {
        if(strStatus =="PROCESSING") {
            context.setStatus("PROCESSING");
        }
        else if(strStatus =="UNDERWRITING") {
            context.setStatus("UNDERWRITING");
        }

        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/test_3/status.vm")).

                when().
                post("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId()
                    +"/status").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).
                assertThat().statusCode(Matchers.equalTo(200)).

                extract().
                response();
        System.out.println("status transition success");
    }
}
