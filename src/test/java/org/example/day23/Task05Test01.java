package org.example.day23;

// One TestCase File for Task05 MessageUtil class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task05Test01  {

    String msg = "running test01";  // Message to test with

    MessageUtil msgUtilObj = new MessageUtil(msg); // Create MessageUtil object with message

    @Test
    public void msgTest() {
        System.out.println("We are inside msgTest() of Task05Test01");
        assertEquals(msg, msgUtilObj.printMessage());  // Check if printMessage() returns the message
    }
}

