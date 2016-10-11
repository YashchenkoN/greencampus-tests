package ua.greencampus.tests.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Mykola Yashchenko
 */
@Getter
@Setter
public class EntityListResponse<T> extends BaseResponse {
    private List<T> entities;
}
