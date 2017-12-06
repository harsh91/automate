package oxyzo.methods;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import org.json.JSONException;
import org.json.JSONObject;
import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 25/11/17.
 */
public class LoanAppCreate_2 extends BaseUtils {
    public ValidatableResponse vResponse =null;
    public Response responseCreateApp =null;
    String loanAppId="";
    String applicantAppId="";

    private static final Context context = Context.getInstance();

    public String testNfeLogin() {
        String authToken = null;
        try {
            vResponse =
                given().log().all()
                    .contentType("application/json")
                    .body(VelocityTemplateFactory.convertTemplateToString(
                        "src/main/resources/template/login/buyerLogin.vm"))
                    .when()
                    .post("http://stg-api.ofbusiness.in/api/v1/account/login").
                    then();
            context.response = vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", Matchers.equalTo(null)).
                assertThat().statusCode(Matchers.equalTo(200)).

                extract().
                response();

            JsonPath jsonPath = context.response.jsonPath();
            context.setAuthToken(jsonPath.getString("data.token"));

            System.out.print("auth token1:" + context.getAuthToken());
        } catch (Exception e) {
            String errorResponseBody = context.vResponse.extract().response().print();
            String errorMessage = null;
            try {
                JSONObject jsonObject = new JSONObject(errorResponseBody);
                errorMessage = jsonObject.getString("errorMessage");
            } catch (JSONException e1) {
                //ignore
            }
            System.out.println("-------Test failed login---> so no token-----error message:-->"+errorMessage);
        }
        return authToken;
    }

    public String loanApp()
    {
        System.out.println("auth token: "+ context.getAuthToken());
        vResponse =
            given().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAuthToken()).
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
        loanAppId= responseCreateApp.jsonPath().getString("data.loanApplicationId");
        applicantAppId= responseCreateApp.jsonPath().getString("data.applicantApplicationId");
        System.out.println("loan App Id: "+loanAppId);
        System.out.println("loan App Id: "+applicantAppId);
        return loanAppId;
    }
}
