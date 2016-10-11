package ua.greencampus.tests.rule;

import ua.greencampus.tests.common.response.ResponseStatus;
import ua.greencampus.tests.service.UserService;

import java.util.UUID;

/**
 * @author Mykola Yashchenko
 */
public class UserRule extends AbstractRule {

    private UserService userService = getService(UserService.class);

    private String email;
    private String password;
    private String userId;

    public UserRule() {
        this(UUID.randomUUID().toString() + "@email.com", UUID.randomUUID().toString());
    }

    public UserRule(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void before() {
        userId = userService.create(email, password);
    }

    @Override
    public void after() {
        userService.delete(userId, ResponseStatus.SUCCESS, "user deleted successfully");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
}
