// @Before and @After annotations usage

package org.example.day22;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JUnitTestCase04 {

    private String str;

    @Before
    public void setUp() {
        System.out.println("setUp method called");
        str = "initialise the setup";
    }

    @After
    public void tearDown() {
        System.out.println("tearDown method called");
        str = null;
    }

    @Test
    public void testStrInitialSetup() {
        assertEquals("initialise the setup", str);
    }

    @Test
    public void testStrCleanUp() {

        assertEquals("initialise the setup", str);
    }

    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(JUnitTestCase04.class);
        if (res.getFailureCount() > 0) {
            System.out.println("Number of FAILURES: " + res.getFailureCount());
            for (Failure failure : res.getFailures()) {
                System.out.println(failure.toString());
            }
        } else {
            System.out.println("All tests PASSED");
        }
    }
}
