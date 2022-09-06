package classes;

public class ResponseDocUploadServer {
    private ResponseDocUploadServer.Response response;
    public class Response{
        private String upload_url;
    }

    public String getDocUploadUrl(){
        return this.response.upload_url;
    }
}
