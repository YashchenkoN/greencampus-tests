package ua.greencampus.tests.action;

/**
 * @author Mykola Yashchenko
 */
public interface Action<T> {
    T execute();
}
