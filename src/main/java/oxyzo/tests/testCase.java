package oxyzo.tests;

import oxyzo.methods.BaseUtils;
import org.testng.annotations.Test;
import oxyzo.methods.LoanAppCreate_1;
import oxyzo.methods.LoanAppCreate_2;
import oxyzo.methods.LoanAppCreate_3;
import oxyzo.methods.LoanAppCreate_4;
import oxyzo.methods.LoanAppCreate_5;

/**
 * Created by nitika.
 */
public class testCase extends BaseUtils {

    LoanAppCreate_1 lC1 = new LoanAppCreate_1();
    LoanAppCreate_2 lC2 = new LoanAppCreate_2();
    LoanAppCreate_3 lC3 = new LoanAppCreate_3();
    LoanAppCreate_4 lC4 = new LoanAppCreate_4();
    LoanAppCreate_5 lC5 = new LoanAppCreate_5();


    /* @Test(groups = {"1"})
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

    /* -------------for option 3--------*/
  /*  @Test(groups = {"3"}, priority = 1)
    public void login_test_case_3() {
        System.out.println("==============option 3===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"3"},priority = 2)
    public void testOxyzo3() {
        lC2.loanApp();
    }

    @Test(groups = {"3"},priority = 3)
    public void testVerifiedCustomer() {
        lC3.loanAppVerifiedCust();
    }

    @Test(groups = {"3"}, priority = 4)
    public void testStatus() {
        lC3.loanAppStatusUpdate("PROCESSING");
    }

    /* -------------for option 4--------*/
   /* @Test(groups = {"4"}, priority = 1)
    public void login_test_case_4() {
        System.out.println("==============option 4===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"4"},priority = 2)
    public void testOxyzo4() {
        lC2.loanApp();
    }

    @Test(groups = {"4"},priority = 3)
    public void testVerifiedCustomer_1() {
        lC3.loanAppVerifiedCust();
    }

    @Test(groups = {"4"}, priority = 4)
    public void testStatus_1() {

        lC3.loanAppStatusUpdate("PROCESSING");
    }

    @Test(groups = {"4"}, priority = 5)
    public void testPdFormSales_1() {

        lC4.loanPdFormSales();
    }

    @Test(groups = {"4"}, priority = 5)
    public void testStatusUnderWrit_1()
    {
        lC3.loanAppStatusUpdate("UNDERWRITING");
    }

    /* -------------for option 5--------*/
    @Test(groups = {"5"}, priority = 1)
    public void login_test_case_5() {
        System.out.println("==============option 5===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"5"},priority = 2)
    public void testOxyzo5() {
        lC2.loanApp();
    }

    @Test(groups = {"5"},priority = 3)
    public void testVerifiedCustomer_2() {
        lC3.loanAppVerifiedCust();
    }

    @Test(groups = {"5"}, priority = 4)
    public void testStatus_2() {
        lC3.loanAppStatusUpdate("PROCESSING");
    }

    @Test(groups = {"5"}, priority = 5)
    public void testPdFormSales_2() {
        lC4.loanPdFormSales();
    }

    @Test(groups = {"5"}, priority = 5)
    public void testStatusUnderWrit_2()
    {
        lC3.loanAppStatusUpdate("UNDERWRITING");
    }
    @Test(groups = {"5"}, priority = 6)
    public void testFillUvObservation_1() {

        lC5.fillUvObservation();
    }
    @Test(groups = {"5"}, priority = 7)
    public void testCompareObservation_1() {
        lC5.CompareObservation();
    }
}