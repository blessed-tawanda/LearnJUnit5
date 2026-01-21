package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * assertThrows assertions is used to assert that an executable peace of code throws an exception
 * assertThrows(expectedException, executable)\
 * If the expectedException is a super to the exception thrown the test will pass.
 * If the exception thrown does not match the expectedException the test will fail.
 * if no exception is thrown the test will fail.
 */
public class AssertThrowsAssertionTest {

    /**
     * This test pass exception was thrown on trying to do the impossible math 1/0
     */
    @Test
    public void testAssertThrowsAssertion() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int a = 1 / 0;
        });
    }

    /**
     * This test fails no exeption was thrown
     */
    @Test
    public void test2AssertThrowsAssertion() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int a = 3/2;
        });
    }

    /**
     * This test pass since RuntimeException is Super Class to ArithmeticException
     */
    @Test
    public void test3AssertThrowsAssertion() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            int a = 1/0;
        });
    }



}
