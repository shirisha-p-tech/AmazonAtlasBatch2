// JUnit test suite to run multiple test classes together
package org.example.day22;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JUnitTestCase01.class,
        JUnitTestCase02.class
})
public class JUnitTestSuite {
}