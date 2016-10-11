package ua.greencampus.tests.test;

import ua.greencampus.tests.client.Client;
import ua.greencampus.tests.client.GreenCampusClient;
import ua.greencampus.tests.service.AbstractService;
import ua.greencampus.tests.service.ServiceFactory;

/**
 * @author Mykola Yashchenko
 */
public abstract class BaseTest {
    protected Client client;
    protected ServiceFactory serviceFactory;

    public BaseTest() {
        String url = System.getProperty("url");
        // todo
        this.client = new GreenCampusClient("http://localhost:8080/api");
        this.serviceFactory = new ServiceFactory(client);
    }

    public <T extends AbstractService> T getService(Class<T> service, String email, String password) {
        // todo
        return new ServiceFactory(new GreenCampusClient("http://localhost:8080/api", email, password)).build(service);
    }
}
