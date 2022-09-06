package utils;

public enum StatusCodes {
    GETSUCCESS(200),
    GETERROR(404),
    POSTSECCESS(201);

    public int code;
    StatusCodes(int code) {
        this.code = code;
    }
}
