package cn.run.java.commons.exception;

/**
 * @author 郑查磊
 * @date 2019/5/29 11:37
 * @email <a href="mailto:stone981023@gmail.com">stone</a>
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
