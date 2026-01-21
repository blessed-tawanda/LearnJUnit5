package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertTrueAssertionTest {

    /**
     * This is just inverse of assertFalse, read assertFalse for reference
     */
    @Test
    public void assertionAssertTrueTest() {
        String fullname = "Blessed Tawanda Mahuni";
        String firstName = fullname.split(" ")[0];
        Assertions.assertTrue(5 == 5);
    }
}
