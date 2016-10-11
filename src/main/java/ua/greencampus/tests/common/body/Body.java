package ua.greencampus.tests.common.body;

import ua.greencampus.tests.entity.BaseResponse;

import java.lang.reflect.Type;

/**
 * @author Mykola Yashchenko
 */
public interface Body {
    String getContent();
    <T extends BaseResponse> T getContent(Type type);
}
