package ua.greencampus.tests.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mykola Yashchenko
 */
@Getter
@Setter
public class EntityResponse<T> extends BaseResponse {
    private T entity;
}
