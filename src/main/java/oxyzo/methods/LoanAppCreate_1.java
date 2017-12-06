package oxyzo.methods;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 25/11/17.
 */
public class LoanAppCreate_1 extends BaseUtils {
    public ValidatableResponse vResponse =null;
    public Response responseCreateApp =null;
    String loanAppId="";

    private static final Context context = Context.getInstance();

    public String loanApp()
    {
        vResponse =
            given().log().all().
                contentType("application/json").
                header("x-ofb-platform", "WEB_SITE").
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/test_1/newApp.vm")).

                when().
                post("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/lead").

                then();
        responseCreateApp=
            vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
        loanAppId= responseCreateApp.jsonPath().getString("data.applicationId");
        System.out.println("loan App Id: "+loanAppId);
        return loanAppId;
    }
}
