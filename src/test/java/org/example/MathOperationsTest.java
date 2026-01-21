package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathOperationsTest {

    MathOperations mathOperations;

    @BeforeEach()
    void init() {
        System.out.println("Initializing Math Operations");
        mathOperations = new MathOperations();
    }

    @Test
    @DisplayName("Addition Test")
    void testAdd() {
        System.out.println("Test Add 1 + 4 = 5");
        int expected = 5;
        int actual = mathOperations.add(1,4);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Substraction Test")
    void testSub() {
        System.out.println("Test Substraction 1 - 4 != 5");
        int expected = 5;
        int actual = mathOperations.sub(1,4);
        Assertions.assertNotEquals(expected,actual);
    }

    @Test
    @DisplayName("Multiplication Test")
    void testMul() {
        System.out.println("Test Multiplication 2 * 2 = 4");
        int expected = 4;
        int actual = mathOperations.mul(2,2);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Division Test")
    void testDiv() {
        System.out.println("Test Division 3 / 4 != 1");
        int expected = 1;
        float actual = mathOperations.div(3,4);
        Assertions.assertNotEquals(expected,actual);
    }
}