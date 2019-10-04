package cn.baiyu.common.exception;

public abstract class BaseGlobalException extends RuntimeException {

    private static final long serialVersionUID = 373040323746336479L;

    public BaseGlobalException(String message) {
        super(message);
    }

    public BaseGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseGlobalException(Throwable cause) {
        super(cause);
    }

    public abstract BaseGlobalException.ExceptionType getType();

    public BaseGlobalException() {
    }

    public interface ExceptionType {
    }
}