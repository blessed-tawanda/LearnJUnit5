package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AssertFalseAssertionTest {
    @Test
    /**
     * assertFalse checks if the boolean given is false, if so the Test passes,
     * below is an example of a test that will always pass since the boolean
     * passed will be false except for a very specific time 😉.
     */
    public void testIfTodayIsMyBirthday() {
        LocalDateTime birthday = LocalDateTime.of(2026, 8, 18, 00, 00, 00);
        Assertions.assertFalse(birthday.isEqual(LocalDateTime.now()));
    }
}
