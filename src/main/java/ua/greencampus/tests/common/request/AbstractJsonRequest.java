package ua.greencampus.tests.common.request;

import ua.greencampus.tests.common.body.Body;
import ua.greencampus.tests.common.GreenCampusApi;
import ua.greencampus.tests.common.body.JsonBody;

/**
 * @author Mykola Yashchenko
 */
public abstract class AbstractJsonRequest extends AbstractRequest {

    public AbstractJsonRequest(GreenCampusApi url) {
        super(url);
    }

    public Body getBody() {
        return new JsonBody(this);
    }
}
