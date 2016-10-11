package ua.greencampus.tests.common.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.greencampus.tests.common.GreenCampusApi;

/**
 * @author Mykola Yashchenko
 */
public abstract class AbstractRequest implements Request {

    protected transient GreenCampusApi url;
    protected transient Gson gson = new GsonBuilder().create();

    public AbstractRequest(GreenCampusApi url) {
        this.url = url;
    }

    public String getUrl() {
        return url.getUrl();
    }
}
