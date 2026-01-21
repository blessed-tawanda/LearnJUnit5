package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertionsWithArraysTest {
    /**
     * assertArrayEquals tests if to given arrays are identical even the element order, test fails if the arrays are
     * not the same
     */
    @Test
    public void assertionWithArrayTest() {
        int[] expected = {1,2,3};
        int[] actual = {1,2,3};
        Assertions.assertArrayEquals(expected,actual);
    }

    /**
     * This test fails because the arrays are not the same or identical
     */
    @Test
    public void assertionWithArrayTest2() {
        int[] expected = {1,2,3};
        int[] actual = {3,2,1};
        Assertions.assertArrayEquals(expected,actual);
    }
}
