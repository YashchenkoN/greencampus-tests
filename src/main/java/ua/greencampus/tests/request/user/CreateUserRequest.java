package ua.greencampus.tests.request.user;

import ua.greencampus.tests.common.GreenCampusApi;
import ua.greencampus.tests.common.request.AbstractJsonRequest;

/**
 * @author Mykola Yashchenko
 */
public class CreateUserRequest extends AbstractJsonRequest {
    private String email;
    private String password;

    public CreateUserRequest(String email, String password) {
        super(GreenCampusApi.USER);
        this.email = email;
        this.password = password;
    }
}
