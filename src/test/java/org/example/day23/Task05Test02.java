package org.example.day23;

// Another TestCase for MessageUtil class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task05Test02 {

    String msg = "running test02";  // Another message for testing

    MessageUtil msgUtilObj = new MessageUtil(msg);  // Create MessageUtil object with different message

    @Test
    public void msgTest() {
        System.out.println("We are inside msgTest() of Task05Test02");
        assertEquals(msg, msgUtilObj.printMessage());  // Check if printMessage() returns the correct message
    }
}

