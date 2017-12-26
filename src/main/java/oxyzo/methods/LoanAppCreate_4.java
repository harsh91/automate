package oxyzo.methods;

import com.jayway.restassured.response.Response;
import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 12/12/17.
 * 4- loan_app status-underwriting \n
 */
public class LoanAppCreate_4 extends BaseUtils{

    private static final Context context = Context.getInstance();
    public Response response =null;

    public void loanPdFormSales()
    {
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAdminAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString
                    ("src/main/resources/template/test_3/pdForm.vm")).

                when().
                post("/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId() +"/pdform").

                then();
        response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
    }
}
