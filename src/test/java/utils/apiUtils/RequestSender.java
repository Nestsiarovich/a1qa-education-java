package utils.apiUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import static aquality.selenium.browser.AqualityServices.*;
import static utils.managers.DataManager.*;
import static utils.managers.DataManager.DataKeys.*;

public class RequestSender {
    public static Response getAccessTokenApi(String Variant){
        RequestBuilder requestBuilder = new RequestBuilder();
        String request = requestBuilder
                .createNewRequest()
                .addMethod(getDataValue(METHOD_TOKEN_GET))
                .addParam(getDataValue(PARAM_VARIANT),Variant)
                .toString();
        return RestAssured.post(request);
    }

    public static Response getTestsJsonApi(String projectId){
        RequestBuilder requestBuilder = new RequestBuilder();
        String request = requestBuilder
                .createNewRequest()
                .addMethod(getDataValue(METHOD_TEST_GET_JSON))
                .addParam(getDataValue(PARAM_PROJECT_ID),projectId)
                .toString();
        return RestAssured.post(request);
    }

    public static Response putTestApi(String sid, String projectName, String testName, String methodName, String env){
        RequestBuilder requestBuilder = new RequestBuilder();
        String request = requestBuilder
                .createNewRequest()
                .addMethod(getDataValue(METHOD_TEST_PUT))
                .addParam(getDataValue(PARAM_SID), sid)
                .addParam(getDataValue(PARAM_PROJECT_NAME), projectName)
                .addParam(getDataValue(PARAM_TEST_NAME), testName)
                .addParam(getDataValue(PARAM_METHOD_NAME), methodName)
                .addParam(getDataValue(PARAM_ENV), env)
                .toString();
        return RestAssured.post(request);
    }

    public static Response putTestLogApi(String testId, String content){
        RequestBuilder requestBuilder = new RequestBuilder();
        String request = requestBuilder
                .createNewRequest()
                .addMethod(getDataValue(METHOD_TEST_PUT_LOG))
                .addParam(getDataValue(PARAM_TEST_ID), testId)
                .addParam(getDataValue(PARAM_CONTENT), content)
                .toString();
        return RestAssured.post(request);
    }

    public static Response putTestAttachment(String testId, String content, String contentType){
        RequestBuilder requestBuilder = new RequestBuilder();
        String request = requestBuilder
                .createNewRequest()
                .addMethod(getDataValue(METHOD_TEST_PUT_ATTACHMENT))
                .toString();
        return RestAssured.given().contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam(getDataValue(PARAM_TEST_ID), testId)
                .formParam(getDataValue(PARAM_CONTENT), content)
                .formParam(getDataValue(PARAM_CONTENT_TYPE), contentType).when().post(request.replace("?", ""));
    }

    public static void sendCookieApi(String param, String value){
        getBrowser().getDriver().manage().addCookie(new Cookie(param, value));
    }
}
