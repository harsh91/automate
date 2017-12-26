package oxyzo.utils;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.response.Response;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by nitika on 24/11/17.
 */
public class Context {
    protected Context() {
        // no instance creation
    }

    private static final Context instance = new Context();
    Resource resource;
    Properties properties = null;
    public String testAccountID;
    public ValidatableResponse vResponse = null;
    public Response response = null;
    public String baseURI;
    public String cmsbaseURI;
    public String apiURI;
    public String authToken;
    public String loanAppId;
    public String applicantAppId;
    public String status;
    public String loanRequestId;
    public String loanId;
    public String adminAuthToken;
    public String testMobile = "1000000000";
    public String testPassword = "##ofbdevautomation@2016##";

    public static Context getInstance() {
        return instance;
    }

    public Resource getResource(String stgType) {
        if (stgType != null && stgType.equals("1")) {
            return new ClassPathResource("staging/environment.properties");
        } else {
            return new ClassPathResource("staging/environment_stg2.properties");
        }
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getTestAccountID() {
        return testAccountID;
    }

    public void setTestAccountID(String testAccountID) {
        this.testAccountID = testAccountID;
    }

    public ValidatableResponse getvResponse() {
        return vResponse;
    }

    public void setvResponse(ValidatableResponse vResponse) {
        this.vResponse = vResponse;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public String getCmsbaseURI() {
        return cmsbaseURI;
    }

    public void setCmsbaseURI(String cmsbaseURI) {
        this.cmsbaseURI = cmsbaseURI;
    }

    public String getApiURI() {
        return apiURI;
    }

    public void setApiURI(String apiURI) {
        this.apiURI = apiURI;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getLoanAppId() {
        return loanAppId;
    }

    public void setLoanAppId(String loanAppId) {
        this.loanAppId = loanAppId;
    }

    public String getApplicantAppId() {
        return applicantAppId;
    }

    public void setApplicantAppId(String applicantAppId) {
        this.applicantAppId = applicantAppId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanRequestId() {
        return loanRequestId;
    }

    public void setLoanRequestId(String loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getAdminAuthToken() {
        return adminAuthToken;
    }

    public void setAdminAuthToken(String adminAuthToken) {
        this.adminAuthToken = adminAuthToken;
    }

    public void setTestPassword(String testPassword) {
        this.testPassword = testPassword;
    }

    public String getTestMobile() {
        return testMobile;
    }

    public void setTestMobile(String testMobile) {
        this.testMobile = testMobile;
    }

    public String getTestPassword() {
        return testPassword;
    }
}
