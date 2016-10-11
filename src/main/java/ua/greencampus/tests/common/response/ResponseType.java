package ua.greencampus.tests.common.response;

import com.google.gson.reflect.TypeToken;
import ua.greencampus.tests.entity.EntityResponse;
import ua.greencampus.tests.entity.User;

import java.lang.reflect.Type;

/**
 * @author Mykola Yashchenko
 */
public enum ResponseType {
    USER_ENTITY(new TypeToken<EntityResponse<User>>() {}.getType());

    Type type;

    ResponseType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
