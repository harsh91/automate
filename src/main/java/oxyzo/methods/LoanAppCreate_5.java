package oxyzo.methods;

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
                post("http://stg-oxyzo-api.ofbusiness"
                    + ".in/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId() +"/uwobservations").

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
                post("http://stg-oxyzo-api.ofbusiness"
                    + ".in/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId()
                    +"/pdform?creatorType=UNDERWRITER").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
    }
}
