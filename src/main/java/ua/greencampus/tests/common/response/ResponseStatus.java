package ua.greencampus.tests.common.response;

/**
 * @author Mykola Yashchenko
 */
public enum ResponseStatus {
    SUCCESS, ERROR, FORBIDDEN, UNAUTHORIZED;

    public static ResponseStatus fromCode(int statusCode) {
        switch (statusCode) {
            case 400:
                return ERROR;
            case 401:
                return UNAUTHORIZED;
            case 403:
                return FORBIDDEN;
            default:
                return SUCCESS;
        }
    }
}
