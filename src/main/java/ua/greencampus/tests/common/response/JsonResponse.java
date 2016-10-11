package ua.greencampus.tests.common.response;

import ua.greencampus.tests.common.body.Body;
import ua.greencampus.tests.common.body.JsonBody;

/**
 * @author Mykola Yashchenko
 */
public class JsonResponse extends AbstractResponse {

    public JsonResponse(String content, int statusCode) {
        super(content, statusCode);
    }

    public Body getBody() {
        return new JsonBody(content);
    }
}
