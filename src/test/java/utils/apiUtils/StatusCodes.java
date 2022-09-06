package utils.apiUtils;

public enum StatusCodes {
    SUCCESS(200);

    public int code;
    StatusCodes(int code) {
        this.code = code;
    }
}
