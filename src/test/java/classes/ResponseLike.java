package classes;

public class ResponseLike {
    private Response response;
    public class Response{
        private int liked;
        private int copied;
    }

    public int getLikedCode(){
        return this.response.liked;
    }
}
