package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Performance driven tests are time-sensitive tests, e.g.
 * when testing if a process is running under the stipulated timeframe, testing if user profile data
 * is being fetched under 1 sec.
 *
 * To achieve this JUnit5 provides
 * - @Timeout annotation this annotation can be at method level or class level if at class level all the tests
 *   within the class must run under the stipulated test time, as shown by this class all tests must run under 6 seconds
 * - assertTimeout()
 * - assertTimeoutPreemptively()
 */
@Timeout(20)
public class PerformanceDrivenTest {

    /**
     * Test should fail since it takes 3 seconds and the timeout is set to 2 seconds,
     * this is testing if the code in the method is running under 2 sec
     * @throws InterruptedException Thread exception
     */
    @Test
    @Timeout(2)
    public void shouldTake2SecTest() throws InterruptedException {
        Thread.sleep(3000);
    }


    /**
     * Test should pass since it is running under 3000 Milliseconds, it only takes 2000 Milliseconds
     * Here showing Timeout annotation can take units using java TimeUnit class.
     * Default value is in seconds as shown by shouldTake2SecTest
     * @throws InterruptedException Thread exception
     */
    @Test
    @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS)
    public void shouldTake3SecTest() throws InterruptedException {
        Thread.sleep(2000);
    }

    /**
     * Test should pass since it is running under 4000 Milliseconds,
     * this another way of testing running time with assertTimeout
     * @throws InterruptedException Thread exception
     */
    @Test
    public void shouldTake4SecTest() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofMillis(4000), () -> {
            Thread.sleep(3900);
        });
    }

    /**
     * Test should run in exactly 5 sec using assertTimeoutPreemptively,
     * test will pass cause it sleeps for 3000 so test will pass.
     * @throws InterruptedException
     */
    @Test
    public void shouldTake5SecTest() throws InterruptedException {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            Thread.sleep(3000);
        });
    }

    /**
     * Test should run in 6 sec exactly using assertTimeoutPreemptively,
     * Test fails because it sleeps for 7 sec which is longer that timeout period so test fails, here the assertion
     * assertTimeoutPreemptively will terminate execution when set timeout is reached.
     * assertTimeoutPreemptively can do this because it runs in separate thread
     * @throws InterruptedException
     */
    @Test
    public void shouldTake6SecTest() throws InterruptedException {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(6000), () -> {
            Thread.sleep(7000);
        });
    }
}
