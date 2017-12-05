package oxyzo.tests;

import org.testng.annotations.Test;
import oxyzo.methods.LoanApplicationCreate;

/**
 * Created by nitika.
 */
public class testCase extends LoanApplicationCreate {

    LoanApplicationCreate lC = new LoanApplicationCreate();

    @Test(groups = {"1"})
    public void testOxyzo() {
        System.out.println("==============1===================");
        lC.loanApp();
    }

    @Test(groups = {"2"})
    public void testOxyzo2() {
        System.out.println("==============2===================");
        lC.loanApp();
    }
}