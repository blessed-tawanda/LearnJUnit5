package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupedAssertionsTest {

    /**
     * A way of bundling your Assertions for example testing multiple scenario
     * with diff variables for the processed by same method, e.g. possible values testing addition with various inputs
     */
    @Test
    public void additionMathOperationsTest() {
        MathOperations mathOperations = new MathOperations();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, mathOperations.add(1,1)),
                () -> Assertions.assertEquals(4, mathOperations.add(2,2)),
                () -> Assertions.assertEquals(6, mathOperations.add(3,3))
        );
    }
}
