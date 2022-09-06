package utils.VkApiUtils;

import classes.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static utils.JsonParser.*;
import static utils.Managers.ConfigManager.*;
import static utils.Managers.DataManager.*;

public class VkApiRequestSender {
    public static ResponsePostId addPostApi(String massage){
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodWallPost())
                .addParam(getParamKeyMassage(), massage)
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        Response response = RestAssured.post(request);
        return parseJsonToResponsePostId(response.body().asString());
    }

    public static ResponseDocUploadServer getUploadServerApi(){
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodDocsGetWallUploadServer())
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        Response response = RestAssured.post(request);
        System.out.println("ResponseDocUploadServer" + response.body().asString());
        return parseJsonToResponseDocUploadServer(response.body().asString());
    }

    public static ResponseFile uploadFileToServerApi(String uploadUrl){
        Response response = given()
                .multiPart("file", new File(getPathToUploadDoc()))
                .when()
                .post(uploadUrl)
                .then().extract().response();
        System.out.println("uploadFileToServerApi" + response.body().asString());
        return parseJsonToResponseFile(response.body().asString());
    }

    public static ResponseDoc saveDocApi(String file){
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodDocsSave())
                .addParam(getParamKeyFile(), file)
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        Response response = RestAssured.post(request);
        return parseJsonToResponseDoc(response.body().asString());
    }

    public static void editPostAddDocApi(String postId, String massage, String image) {
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodWallEdit())
                .addParam(getParamKeyPostId(), postId)
                .addParam(getParamKeyMassage(), massage)
                .addParam(getParamKeyAttachments(), image)
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        RestAssured.post(request);
    }

    public static void addCommentToPostApi(String postId, String massage){
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodWallCreateComment())
                .addParam(getParamKeyPostId(), postId)
                .addParam(getParamKeyMassage(), massage)
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        RestAssured.post(request);
    }
    public static ResponseLike getPostLikeApi(String postId) {
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodLikesIsLiked())
                .addParam(getParamKeyType(), getParamValueType())
                .addParam(getParamKeyItemId(), postId)
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        Response response = RestAssured.get(request);
        return parseJsonToResponseLike(response.body().asString());
    }

    public static void deletePostApi(String postId){
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod(getMethodWallDelete())
                .addParam(getParamKeyPostId(), postId)
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        RestAssured.post(request);
    }

    public static ResponseUser getUserApi(){
        VkApiRequestBuilder buildRequest = new VkApiRequestBuilder();
        String request = buildRequest
                .createNewRequest()
                .addMethod("users.get")
                .addToken(getToken())
                .addVersion(getVersion())
                .toString();
        Response response = RestAssured.get(request);
        return parseJsonToResponseUser(response.body().asString());
    }
}
