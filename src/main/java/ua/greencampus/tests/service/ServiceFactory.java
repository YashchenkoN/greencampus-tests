package ua.greencampus.tests.service;

import ua.greencampus.tests.client.Client;

import java.lang.reflect.Constructor;

/**
 * @author Mykola Yashchenko
 */
public class ServiceFactory {
    private Client client;

    public ServiceFactory(Client client) {
        this.client = client;
    }

    public <T extends AbstractService> T build(Class<? extends T> service) {
        try {
            Constructor<? extends T> constructor = service.getConstructor(Client.class);
            return constructor.newInstance(client);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
