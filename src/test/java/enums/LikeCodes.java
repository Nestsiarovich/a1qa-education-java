package enums;

public enum LikeCodes {
    IS_LIKED(1),
    IS_NOT_LIKED(0);

    private int code;

    LikeCodes(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
