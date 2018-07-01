package com.yl.sql.exception;

/**
 * 参数不匹配异常
 */
public class ParameterNotMatchException extends RuntimeException {

    public static final String BASE_MESSAGE = "Parameters not met these condition :\n";

    public ParameterNotMatchException(String message) {
        super(message);
    }

    public ParameterNotMatchException(Throwable cause) {
        super(cause);
    }

    public ParameterNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

}
