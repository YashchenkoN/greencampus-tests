package ua.greencampus.tests.test;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import ua.greencampus.tests.common.response.ResponseStatus;
import ua.greencampus.tests.entity.User;
import ua.greencampus.tests.rule.UserRule;
import ua.greencampus.tests.service.UserService;

import java.util.UUID;

/**
 * @author Mykola Yashchenko
 */
public class UpdateUserTest extends BaseTest {

    @ClassRule
    public static UserRule userRule = new UserRule();
    @ClassRule
    public static UserRule user2Rule = new UserRule();
    private UserService userService = getService(UserService.class, userRule.getEmail(), userRule.getPassword());

    @Test
    public void testUpdate() {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString() + "@email.com");
        userService.update(userRule.getUserId(), user);
    }

    @Test
    public void testUpdateInvalid() {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString() + "@email.com");
        userService.update(user2Rule.getUserId(), user, ResponseStatus.FORBIDDEN,
                "you do not have permissions to do this operation");
    }
}
