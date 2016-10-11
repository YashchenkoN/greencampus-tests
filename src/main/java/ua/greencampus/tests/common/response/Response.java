package ua.greencampus.tests.common.response;

import ua.greencampus.tests.common.body.Body;

/**
 * @author Mykola Yashchenko
 */
public interface Response {
    ResponseStatus getStatus();
    Body getBody();
}
