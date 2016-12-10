package ua.greencampus.tests.test;

import ua.greencampus.tests.client.GreenCampusClient;
import ua.greencampus.tests.common.Users;
import ua.greencampus.tests.service.AbstractService;
import ua.greencampus.tests.service.ServiceFactory;

/**
 * @author Mykola Yashchenko
 */
public abstract class BaseTest {

    public BaseTest() {
        String url = System.getProperty("url");
    }

    public static <T extends AbstractService> T getService(Class<T> service) {
        return getService(service, Users.ADMIN.getEmail(), Users.ADMIN.getPassword());
    }

    public static <T extends AbstractService> T getService(Class<T> service, String email, String password) {
        // todo
        return new ServiceFactory(new GreenCampusClient("http://localhost:8080/api", email, password)).build(service);
    }
}
