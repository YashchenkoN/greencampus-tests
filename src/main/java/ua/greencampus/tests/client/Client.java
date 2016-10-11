package ua.greencampus.tests.client;

import ua.greencampus.tests.common.request.Request;
import ua.greencampus.tests.common.response.Response;

/**
 * @author Mykola Yashchenko
 */
public interface Client {
    Response get(Request request);
    Response post(Request request);
    Response put(Request request);
    Response delete(Request request);
}
