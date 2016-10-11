package ua.greencampus.tests.common.response;

/**
 * @author Mykola Yashchenko
 */
public enum ResponseStatus {
    SUCCESS, ERROR;

    public static ResponseStatus fromCode(int statusCode) {
        switch (statusCode) {
            case 400:
                return ERROR;
            default:
                return SUCCESS;
        }
    }
}
