package kr.hobeen.apiserver.exceptions;

public class ErrorUtils {

    private ErrorUtils() {}

    public static Error createError(final String errMsgKey, final String errorCode, final Integer httpStatusCode) {
        return Error.of(errorCode, errMsgKey, httpStatusCode);
    }
}
