package org.example.day23;

// Third TestCase for Task05

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task06Test {

    @Test
    public void msgTest() {
        String msg = "running test03";
        System.out.println("We are inside msgTest() of Task06Test");
        assertEquals(msg, "running test03");
    }
}
