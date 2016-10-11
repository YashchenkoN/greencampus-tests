package ua.greencampus.tests;

import org.junit.runner.JUnitCore;
import ua.greencampus.tests.test.CreateUserTest;

/**
 * @author Mykola Yashchenko
 */
public class Main {
    public static void main(String[] args) {
        JUnitCore.runClasses(CreateUserTest.class);
    }
}
