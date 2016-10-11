package ua.greencampus.tests.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import ua.greencampus.tests.client.GreenCampusClient;
import ua.greencampus.tests.service.AbstractService;
import ua.greencampus.tests.service.ServiceFactory;

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

    protected <T extends AbstractService> T getService(Class<T> service) {
        // todo
        return new ServiceFactory(new GreenCampusClient("http://localhost:8080/api")).build(service);
    }

    protected <T extends AbstractService> T getService(Class<T> service, String email, String name) {
        // todo
        return new ServiceFactory(new GreenCampusClient("http://localhost:8080/api", email, name)).build(service);
    }

    public void before() {

    }

    public void after() {

    }
}
