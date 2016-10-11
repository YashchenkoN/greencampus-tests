package ua.greencampus.tests.test;

import org.junit.Rule;
import org.junit.Test;
import ua.greencampus.tests.entity.User;
import ua.greencampus.tests.rule.UserRule;
import ua.greencampus.tests.service.UserService;

import java.util.UUID;

/**
 * @author Mykola Yashchenko
 */
public class UpdateUserTest extends BaseTest {

    @Rule
    public UserRule userRule = new UserRule();
    private UserService userService = getService(UserService.class, userRule.getEmail(), userRule.getPassword());

    @Test
    public void testUpdate() {
        User user = new User();
        user.setEmail(UUID.randomUUID().toString() + "@email.com");
        userService.update(userRule.getUserId(), user);
    }
}
