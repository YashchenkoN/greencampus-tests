package ua.greencampus.tests.service;

import ua.greencampus.tests.client.Client;
import ua.greencampus.tests.common.request.Request;
import ua.greencampus.tests.common.response.Response;
import ua.greencampus.tests.common.response.ResponseStatus;
import ua.greencampus.tests.common.response.ResponseType;
import ua.greencampus.tests.entity.BaseResponse;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Mykola Yashchenko
 */
public abstract class AbstractService {

    private Client client;

    protected AbstractService(Client client) {
        this.client = client;
    }

    protected <T extends BaseResponse> T get(Request request, ResponseType responseType, ResponseStatus expectedStatus,
                                          String... expectedMessages) {
        Response response = client.get(request);
        return postProcess(response, responseType, expectedStatus, expectedMessages);
    }

    protected <T extends BaseResponse> T post(Request request, ResponseType responseType, ResponseStatus expectedStatus,
                                           String... expectedMessages) {
        Response response = client.post(request);
        return postProcess(response, responseType, expectedStatus, expectedMessages);
    }

    protected <T extends BaseResponse> T put(Request request, ResponseType responseType, ResponseStatus expectedStatus,
                                             String... expectedMessages) {
        Response response = client.put(request);
        return postProcess(response, responseType, expectedStatus, expectedMessages);
    }

    protected <T extends BaseResponse> T delete(Request request, ResponseType responseType, ResponseStatus expectedStatus,
                                                String... expectedMessages) {
        Response response = client.delete(request);
        return postProcess(response, responseType, expectedStatus, expectedMessages);
    }

    protected <T extends BaseResponse> T postProcess(Response response, ResponseType responseType,
                                                     ResponseStatus expectedStatus, String... expectedMessages) {
        assertNotNull("response is null", response);
        assertEquals("current status do not match expected", expectedStatus, response.getStatus());

        T content = response.getBody().getContent(responseType.getType());
        if (expectedMessages == null || expectedMessages.length == 0) {
            assertNull(content.getMessages());
        } else {
            assertNotNull(content.getMessages());
            assertEquals(expectedMessages.length, content.getMessages().size());
            assertTrue(Arrays.asList(expectedMessages).containsAll(content.getMessages()));
        }
        return content;
    }
}
