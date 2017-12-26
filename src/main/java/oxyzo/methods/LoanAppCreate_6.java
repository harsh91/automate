package oxyzo.methods;

import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 12/12/17.
 * 6- loan_app_status-offered status \n
 */
public class LoanAppCreate_6 extends BaseUtils{
    private static final Context context = Context.getInstance();

    public void LoanAppStatus(String strStatus)
    {
        if(strStatus=="OFFERED")
        {
            context.setStatus("OFFERED");
        }
        else if(strStatus=="ACCEPTED_BY_CLIENT")
        {
            context.setStatus("ACCEPTED_BY_CLIENT");
        }
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAdminAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString
                    ("src/main/resources/template/test_6/loanAppStatus.vm")).

                when().
                post("/api/v1/oxyzo/admin/loanApplication/"+context.getLoanAppId()
                    +"/loanRequest/"+context.getLoanRequestId()).

                then();
        context.response=
            context.vResponse.
               // assertThat().body("success", equalTo(true)).
                //assertThat().body("errorMessage", equalTo(null)).
                assertThat().statusCode(200).
                extract().
                response();
        if(strStatus=="ACCEPTED_BY_CLIENT") {
            context.setLoanId(context.response.jsonPath().getString("data.loanRequests[0].loanId"));
        }

    }
}
