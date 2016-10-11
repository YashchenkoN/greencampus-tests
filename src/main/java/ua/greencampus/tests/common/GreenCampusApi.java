package ua.greencampus.tests.common;

/**
 * @author Mykola Yashchenko
 */
public enum GreenCampusApi {
    USER("/user/");

    private String url;

    GreenCampusApi(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
