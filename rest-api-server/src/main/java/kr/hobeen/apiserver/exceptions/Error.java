package kr.hobeen.apiserver.exceptions;

public class Error {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String message;
    private Integer status;
    private String url = "Not available";
    private String reqMethod = "Not available";

    private Error() {}

    private Error(String errorCode, String message, Integer status) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
    }

    public static Error of(String errorCode, String message, Integer status) {
        return new Error(errorCode, message, status);
    }

    public void mappingRequestInfo(String url, String reqMethod) {
        this.url = url;
        this.reqMethod = reqMethod;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getReqMethod() {
        return reqMethod;
    }
}
