package classes;

public class ResponseUser {
    private Response[] response;
    public class Response {
        private int id;
        private String firstName;
        private String lastName;
        private boolean canAccessClosed;
        private boolean isClosed;
    }

    public int getUserId(int index){
        return this.response[index].id;
    }
}
