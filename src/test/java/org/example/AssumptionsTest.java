package org.example;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;


/**
 * This is use when testing a long process on which if
 * one item fails or is success we might take the test as failure or success based on the state of the value
 */
public class AssumptionsTest {

    /**
     * Test passes on Windows and text is printed, but test is terminated/aborted on non Windows
     * and text is not printed meaning test execution is terminated/aborted on the assumption line
     */
    @Test
    public void testAssumptions() {
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Windows"));
        System.out.println("Congratulations You Are On Windows");
    }

    /**
     * Test passes on Non Windows OS and text is printed, but test is terminated/aborted on Windows
     * and text is not printed meaning test execution is terminated/aborted on the assumption line
     */
    @Test
    public void test2Assumptions() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Windows"));
        System.out.println("You Are Not On Windows, Where Are You?");
    }
}
