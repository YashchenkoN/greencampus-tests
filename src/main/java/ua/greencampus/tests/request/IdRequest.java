package ua.greencampus.tests.request;

import ua.greencampus.tests.common.GreenCampusApi;
import ua.greencampus.tests.common.request.AbstractJsonRequest;

/**
 * @author Mykola Yashchenko
 */
public class IdRequest extends AbstractJsonRequest {
    private String id;

    public IdRequest(GreenCampusApi url, String id) {
        super(url);
        this.id = id;
    }

    @Override
    public String getUrl() {
        return super.getUrl() + id;
    }
}
