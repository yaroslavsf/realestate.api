package ch.noseryoung.realestate.core.exception.exposederrors;

public class MyError {
    private String message;
    private String code;
    public MyError(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
