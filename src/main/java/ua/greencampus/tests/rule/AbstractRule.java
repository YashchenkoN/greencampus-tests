package ua.greencampus.tests.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Mykola Yashchenko
 */
public abstract class AbstractRule implements TestRule {

    public Statement apply(final Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                statement.evaluate();
                after();
            }
        };
    }

    public void before() {

    }

    public void after() {

    }
}
