package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestSending {
    public static Response getRequest(String request){
        return RestAssured.get(request);
    }

    public static Response postRequest(String body, String request){
        return RestAssured.given().header("Content-type", "application/json").and().body(body)
                .when().post(request).then().extract().response();
    }
}
