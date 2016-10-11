package ua.greencampus.tests.rule;

import java.util.UUID;

/**
 * @author Mykola Yashchenko
 */
public class UserRule extends AbstractRule {

    private String email;
    private String password;

    public UserRule() {
        this.email = UUID.randomUUID().toString() + "@email.com";
        this.password = UUID.randomUUID().toString();
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {
        super.after();
    }
}
