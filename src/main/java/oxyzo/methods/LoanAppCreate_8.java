package oxyzo.methods;
import oxyzo.utils.Context;
import oxyzo.utils.VelocityTemplateFactory;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by nitika on 12/12/17.
 *
 * 	7- loan_app_accepted_status_loan_loan-id_status-waiting_for_docs */
public class LoanAppCreate_8 {
    private static final Context context = Context.getInstance();
    public String strPath=null;
    public void LoanStatus(String strStatus)
    {
        if(strStatus=="DOCS_SENT_TO_NBFC")
        {
            context.setStatus("DOCS_SENT_TO_NBFC");
            strPath="src/main/resources/template/test_8/docToNbfc.vm";
        }
        else if(strStatus=="READY_FOR_DISBURSAL")
        {
            context.setStatus("READY_FOR_DISBURSAL");
            strPath="src/main/resources/template/test_8/readyForDisbursal.vm";
        }
        context.vResponse =
            given().log().all().
                contentType("application/json").
                header("X-OFB-TOKEN", context.getAdminAuthToken()).
                body(VelocityTemplateFactory.convertTemplateToString
                    (strPath)).

                when().
                post("/api/v1/oxyzo/admin/loan/"+context.getLoanId()+"/status").

                then();
        context.response=
            context.vResponse.
                assertThat().body("success", equalTo(true)).
                assertThat().body("errorMessage", equalTo(null)).

                extract().
                response();
    }
}
