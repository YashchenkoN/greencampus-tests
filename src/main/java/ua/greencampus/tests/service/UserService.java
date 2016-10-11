package ua.greencampus.tests.service;

import ua.greencampus.tests.client.Client;
import ua.greencampus.tests.common.GreenCampusApi;
import ua.greencampus.tests.common.response.ResponseStatus;
import ua.greencampus.tests.common.response.ResponseType;
import ua.greencampus.tests.entity.EntityResponse;
import ua.greencampus.tests.entity.User;
import ua.greencampus.tests.request.IdRequest;
import ua.greencampus.tests.request.user.CreateUserRequest;

/**
 * @author Mykola Yashchenko
 */
public class UserService extends AbstractService {

    public UserService(Client client) {
        super(client);
    }

    public String create(String email, String password) {
        return create(email, password, ResponseStatus.SUCCESS);
    }

    public String create(String email, String password, ResponseStatus expectedStatus, String... messages) {
        EntityResponse<User> content = post(new CreateUserRequest(email, password), ResponseType.USER_ENTITY,
                expectedStatus, messages);
        User contentEntity = content.getEntity();
        if (contentEntity != null) {
            return contentEntity.getId();
        }
        return null;
    }

    public User get(String userId) {
        return get(userId, ResponseStatus.SUCCESS);
    }

    public User get(String userId, ResponseStatus expectedStatus, String... messages) {
        EntityResponse<User> content = get(new IdRequest(GreenCampusApi.USER, userId), ResponseType.USER_ENTITY,
                expectedStatus, messages);
        return content.getEntity();
    }

    public User delete(String userId) {
        return delete(userId, ResponseStatus.SUCCESS);
    }

    public User delete(String userId, ResponseStatus expectedStatus, String... messages) {
        EntityResponse<User> content = delete(new IdRequest(GreenCampusApi.USER, userId), ResponseType.USER_ENTITY,
                expectedStatus, messages);
        return content.getEntity();
    }
}
