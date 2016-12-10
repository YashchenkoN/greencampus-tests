package ua.greencampus.tests.test;

import org.junit.Test;
import ua.greencampus.tests.common.TestCase;
import ua.greencampus.tests.common.response.ResponseStatus;
import ua.greencampus.tests.entity.User;
import ua.greencampus.tests.service.UserService;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mykola Yashchenko
 */
@TestCase
public class CreateUserTest extends BaseTest {

    private UserService userService = getService(UserService.class);

    @Test
    public void testSuccessCreate() {
        String email = UUID.randomUUID().toString() + "@email.com";

        String userId = userService.create(email, UUID.randomUUID().toString());
        assertNotNull(userId);

        User user = userService.get(userId);
        assertNotNull(user);
        assertEquals(email, user.getEmail());

        userService.delete(userId, ResponseStatus.SUCCESS, "user deleted successfully");
    }

    @Test
    public void testCreateWithEmptyFields() {
        userService.create(null, UUID.randomUUID().toString(), ResponseStatus.ERROR, "email may not be empty");
        userService.create("", UUID.randomUUID().toString(), ResponseStatus.ERROR, "email may not be empty");

        String email = UUID.randomUUID().toString() + "@email.com";

        userService.create(email, null, ResponseStatus.ERROR, "password may not be empty");
        userService.create(email, "", ResponseStatus.ERROR, "password may not be empty",
                "password size should be 5 or greater");
    }

    @Test
    public void testCreateWithShortPassword() {
        String email = UUID.randomUUID().toString() + "@email.com";
        String shortPassword = "1234";

        userService.create(email, shortPassword, ResponseStatus.ERROR, "password size should be 5 or greater");
    }

    @Test
    public void testCreateUserAlreadyExists() {
        String email = UUID.randomUUID().toString() + "@email.com";

        userService.create(email, UUID.randomUUID().toString());
        userService.create(email, UUID.randomUUID().toString(), ResponseStatus.ERROR, "user with this email already exists");
    }
}
