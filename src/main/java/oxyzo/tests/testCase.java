package oxyzo.tests;

import oxyzo.methods.BaseUtils;
import org.testng.annotations.Test;
import oxyzo.methods.LoanAppCreate_1;
import oxyzo.methods.LoanAppCreate_2;
import oxyzo.methods.LoanAppCreate_3;

/**
 * Created by nitika.
 */
public class testCase extends BaseUtils {

    LoanAppCreate_1 lC1 = new LoanAppCreate_1();
    LoanAppCreate_2 lC2 = new LoanAppCreate_2();
    LoanAppCreate_3 lC3 = new LoanAppCreate_3();

    @Test(groups = {"1"})
    public void testOxyzo() {
        System.out.println("==============option 1===================");
        lC1.loanApp();
    }

    @Test(groups = {"2"})
    public void login() {
        System.out.println("==============option 2===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"2"})
    public void testOxyzo2() {
        lC2.loanApp();
    }

   /* @Test(groups = {"3"}, priority = 1)
    public void login_test_case_3() {
        System.out.println("==============option 3===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"3"},priority = 2)
    public void testOxyzo3() {
        lC2.loanApp();
    }
    @Test(groups = {"3"}, priority = 3)
    public void testAppUpdate() {
        lC3.loanAppUpdate();
    }
    @Test(groups = {"3"}, priority = 4)
    public void testStatus() {
        lC3.loanAppStatusUpdate();
    }*/
}