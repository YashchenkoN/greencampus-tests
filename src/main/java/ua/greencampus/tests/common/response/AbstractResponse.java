package ua.greencampus.tests.common.response;

/**
 * @author Mykola Yashchenko
 */
public abstract class AbstractResponse implements Response {

    protected String content;
    private int statusCode;

    public AbstractResponse(String content, int statusCode) {
        this.content = content;
        this.statusCode = statusCode;
    }

    public ResponseStatus getStatus() {
        return ResponseStatus.fromCode(statusCode);
    }
}
