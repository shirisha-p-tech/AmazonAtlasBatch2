package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTests {

    @Test
    void successfulTest() {
        assertTrue(true);
    }

    @Test
    void failingTest() {
        fail("This test is meant to fail");
    }

    @Test
    @Disabled("Test is disabled for demonstration")
    void skippedTest() {
        // This test will be skipped
    }

    @Test
    void testWithException() {
        throw new RuntimeException("Simulated exception");
    }
}
