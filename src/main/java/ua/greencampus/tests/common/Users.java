package ua.greencampus.tests.common;

/**
 * @author Mykola Yashchenko
 */
public enum Users {
    ADMIN("admin@admin", "pass123");

    private String email;
    private String password;

    Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
