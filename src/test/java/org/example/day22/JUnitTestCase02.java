// TestCase02 - Checking equal numbers
package org.example.day22;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class JUnitTestCase02 {
    int a=10;
    int b=10;

    @Test
    public void checkEquality(){
        assertTrue(a==b);
    }
}
