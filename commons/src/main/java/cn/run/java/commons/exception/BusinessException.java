package cn.run.java.commons.exception;

/**
 * @author 郑查磊
 * @date 2019/5/29 11:37
 * @email <a href="mailto:stone981023@gmail.com">stone</a>
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
