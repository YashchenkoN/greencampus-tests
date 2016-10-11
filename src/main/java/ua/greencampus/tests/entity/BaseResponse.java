package ua.greencampus.tests.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Mykola Yashchenko
 */
@Getter
@Setter
public class BaseResponse {
    private List<String> messages;
}
