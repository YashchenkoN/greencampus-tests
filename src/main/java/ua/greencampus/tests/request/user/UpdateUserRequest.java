package ua.greencampus.tests.request.user;

import lombok.Getter;
import lombok.Setter;
import ua.greencampus.tests.common.GreenCampusApi;
import ua.greencampus.tests.common.request.AbstractJsonRequest;
import ua.greencampus.tests.entity.User;

/**
 * @author Mykola Yashchenko
 */
@Getter
@Setter
public class UpdateUserRequest extends AbstractJsonRequest {
    private String email;
    private String name;
    private String userId;

    public UpdateUserRequest(String userId, User user) {
        super(GreenCampusApi.USER);
        this.email = user.getEmail();
        this.userId = userId;
    }

    @Override
    public String getUrl() {
        return super.getUrl() + "/" + userId;
    }
}
