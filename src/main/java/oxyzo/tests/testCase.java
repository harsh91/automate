package oxyzo.tests;

import oxyzo.methods.BaseUtils;
import org.testng.annotations.Test;
import oxyzo.methods.LoanAppCreate_1;
import oxyzo.methods.LoanAppCreate_2;
import oxyzo.methods.LoanAppCreate_3;
import oxyzo.methods.LoanAppCreate_4;
import oxyzo.methods.LoanAppCreate_5;
import oxyzo.methods.LoanAppCreate_6;
import oxyzo.methods.LoanAppCreate_8;

/**
 * Created by nitika.
 */
public class testCase extends BaseUtils {

    LoanAppCreate_1 lC1 = new LoanAppCreate_1();
    LoanAppCreate_2 lC2 = new LoanAppCreate_2();
    LoanAppCreate_3 lC3 = new LoanAppCreate_3();
    LoanAppCreate_4 lC4 = new LoanAppCreate_4();
    LoanAppCreate_5 lC5 = new LoanAppCreate_5();
    LoanAppCreate_6 lC6 = new LoanAppCreate_6();
    LoanAppCreate_8 lC8 = new LoanAppCreate_8();


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

    /* -------------for option 3--------*/
    @Test(groups = {"3"}, priority = 1)
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
    @Test(groups = {"4"}, priority = 1)
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
    @Test(groups = {"5"}, priority = 8)
    public void testSentToNbfc() {
        lC5.LoanRequest();
    }

    /* -------------for option 6--------*/
    @Test(groups = {"6"}, priority = 1)
    public void login_test_case_6() {
        System.out.println("==============option 6===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"6"},priority = 2)
    public void testOxyzo6() {
        lC2.loanApp();
    }

    @Test(groups = {"6"},priority = 3)
    public void testVerifiedCustomer_3() {
        lC3.loanAppVerifiedCust();
    }

    @Test(groups = {"6"}, priority = 4)
    public void testStatus_3() {
        lC3.loanAppStatusUpdate("PROCESSING");
    }

    @Test(groups = {"6"}, priority = 5)
    public void testPdFormSales_3() {
        lC4.loanPdFormSales();
    }

    @Test(groups = {"6"}, priority = 5)
    public void testStatusUnderWrit_3()
    {
        lC3.loanAppStatusUpdate("UNDERWRITING");
    }
    @Test(groups = {"6"}, priority = 6)
    public void testFillUvObservation_3() {

        lC5.fillUvObservation();
    }
    @Test(groups = {"6"}, priority = 7)
    public void testCompareObservation_3() {
        lC5.CompareObservation();
    }
    @Test(groups = {"6"}, priority = 8)
    public void testSentToNbfc_1() {
        lC5.LoanRequest();
    }
    @Test(groups = {"6"}, priority = 9)
    public void testLoanOffered() {
        lC6.LoanAppStatus("OFFERED");
    }

    /* -------------for option 7--------*/
    @Test(groups = {"7"}, priority = 1)
    public void login_test_case_7() {
        System.out.println("==============option 7===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"7"},priority = 2)
    public void testOxyzo7() {
        lC2.loanApp();
    }

    @Test(groups = {"7"},priority = 3)
    public void testVerifiedCustomer_4() {
        lC3.loanAppVerifiedCust();
    }

    @Test(groups = {"7"}, priority = 4)
    public void testStatus_4() {
        lC3.loanAppStatusUpdate("PROCESSING");
    }

    @Test(groups = {"7"}, priority = 5)
    public void testPdFormSales_4() {
        lC4.loanPdFormSales();
    }

    @Test(groups = {"7"}, priority = 5)
    public void testStatusUnderWrit_4()
    {
        lC3.loanAppStatusUpdate("UNDERWRITING");
    }
    @Test(groups = {"7"}, priority = 6)
    public void testFillUvObservation_4() {

        lC5.fillUvObservation();
    }
    @Test(groups = {"7"}, priority = 7)
    public void testCompareObservation_4() {
        lC5.CompareObservation();
    }
    @Test(groups = {"7"}, priority = 8)
    public void testSentToNbfc_2() {
        lC5.LoanRequest();
    }
    @Test(groups = {"7"}, priority = 9)
    public void testLoanOffered_1() {
        lC6.LoanAppStatus("OFFERED");
    }
    @Test(groups = {"7"}, priority = 10)
    public void testLoanAccepted() {
        lC6.LoanAppStatus("ACCEPTED_BY_CLIENT");
    }

    /* -------------for option 8--------*/
    @Test(groups = {"8"}, priority = 1)
    public void login_test_case_8() {
        System.out.println("==============option 8===================");
        lC2.testNfeLogin();
    }
    @Test(groups = {"8"},priority = 2)
    public void testOxyzo8() {
        lC2.loanApp();
    }

    @Test(groups = {"8"},priority = 3)
    public void testVerifiedCustomer_5() {
        testCreateAutomationAccount();
        fetchAccIdFromToken();
        lC3.loanAppVerifiedCust();
    }

    @Test(groups = {"8"}, priority = 4)
    public void testPdFormSales_5() {
        lC4.loanPdFormSales();
    }
    @Test(groups = {"8"}, priority = 5)
    public void testFillUvObservation_5() {

        lC5.fillUvObservation();
    }
    @Test(groups = {"8"}, priority = 6)
    public void testCompareObservation_5() {
        lC5.CompareObservation();
    }
    @Test(groups = {"8"}, priority = 7)
    public void testScoreCard() {
        lC5.saveScoreCard();
    }
    @Test(groups = {"8"}, priority = 8)

    public void testStatus_5() {
        lC3.loanAppStatusUpdate("PROCESSING");
    }
    @Test(groups = {"8"}, priority = 9)
    public void testStatusUnderWrit_5()
    {
        lC3.loanAppStatusUpdate("UNDERWRITING");
    }
    @Test(groups = {"8"}, priority = 10)
    public void testSentToNbfc_3() {
        lC5.LoanRequest();
    }
    @Test(groups = {"8"}, priority = 11)
    public void testLoanOffered_2() {
        lC6.LoanAppStatus("OFFERED");
    }
    @Test(groups = {"8"}, priority = 12)
    public void testLoanAccepted_1() {
        lC6.LoanAppStatus("ACCEPTED_BY_CLIENT");
    }
    @Test(groups = {"8"}, priority = 13)
    public void testLoanReqForDisbursal() {
        lC8.LoanStatus("DOCS_SENT_TO_NBFC");
        lC8.LoanStatus("READY_FOR_DISBURSAL");
    }
}