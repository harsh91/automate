package oxyzo.tests;
import org.testng.annotations.Test;
import oxyzo.methods.LoanApplicationCreate;

/**
 * Created by nitika.
 */
public class testCase extends LoanApplicationCreate{

LoanApplicationCreate lC =new LoanApplicationCreate();
    @Test(groups = {"sanity"})
    public void testOxyzo() {
        lC.loanApp();
    }

}