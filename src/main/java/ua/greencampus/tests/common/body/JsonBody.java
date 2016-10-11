package ua.greencampus.tests.common.body;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.greencampus.tests.common.response.ResponseType;
import ua.greencampus.tests.entity.BaseResponse;
import ua.greencampus.tests.entity.EntityListResponse;
import ua.greencampus.tests.entity.EntityResponse;

import java.lang.reflect.Type;

/**
 * @author Mykola Yashchenko
 */
public class JsonBody implements Body {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String content;

    public JsonBody(Object object) {
        this.content = gson.toJson(object);
    }

    public JsonBody(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public <T extends BaseResponse> T getContent(Type type) {
        return gson.fromJson(content, type);
    }
}
