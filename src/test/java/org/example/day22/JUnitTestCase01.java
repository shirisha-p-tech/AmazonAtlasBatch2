// TestCase01 - adding numbers
package org.example.day22;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTestCase01 {
    @Test
    public void addition(){
        int num1=10;
        int num2=20;
        int result = num1 + num2;

        assertEquals(30,result);

    }
}
