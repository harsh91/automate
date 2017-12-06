package oxyzo.methods;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import oxyzo.utils.Context;
import org.hamcrest.Matchers;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 25/11/17.
 */
public class LoanAppCreate_3 extends BaseUtils {
    public ValidatableResponse vResponse =null;
    public Response response =null;
    String loanAppId="";
    String applicantAppId="";

    private static final Context context = Context.getInstance();

    public void loanAppUpdate()
    {
        vResponse =
            given().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/test_3/updateApp"
                    + ".vm")).

                when().
                patch("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/admin/loanApplication").

                then();
        response=
            vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).
                assertThat().statusCode(Matchers.equalTo(200)).

                extract().
                response();
        System.out.println("client verified now for further loan application process");

    }

    public void loanAppStatusUpdate()
    {
        vResponse =
            given().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString("src/main/resources/template/test_3/status.vm")).

                when().
                post("http://stg-oxyzo-api.ofbusiness.in/api/v1/oxyzo/admin/loanApplication/"+loanAppId
                    +"/status").

                then();
        response=
            vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).
                assertThat().statusCode(Matchers.equalTo(200)).

                extract().
                response();
        System.out.println("status transition success");
    }
}
