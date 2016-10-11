package ua.greencampus.tests.common.request;

import ua.greencampus.tests.common.body.Body;

/**
 * @author Mykola Yashchenko
 */
public interface Request {
    String getUrl();
    Body getBody();
}
