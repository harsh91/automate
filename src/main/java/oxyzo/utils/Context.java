package oxyzo.utils;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.response.Response;

/**
 * Created by nitika on 24/11/17.
 */
public class Context {
    protected Context() {
        // no instance creation
    }

    private static final Context instance = new Context();
    public ValidatableResponse vResponse =null;
    public Response response =null;
    public String baseURI;
    public String apiURI;
    public String authToken;



    public static Context getInstance() {
        return instance;
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
}
