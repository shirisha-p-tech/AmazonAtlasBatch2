package org.example.day23;

// Testing compare method
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task04Test {

    @Test
    void testCompare() {
        Task04 junit4Test = new Task04();

        System.out.println("Running test for compare method");

        // Test case where n1 > n2
        int result1 = junit4Test.compare(5, 2);
        System.out.println("Result when n1 > n2: " + result1);
        assertEquals(1, result1, "Test failed when n1 > n2");

        // Test case where n1 < n2
        int result2 = junit4Test.compare(2, 5);
        System.out.println("Result when n1 < n2: " + result2);
        assertEquals(-1, result2, "Test failed when n1 < n2");


    }
}