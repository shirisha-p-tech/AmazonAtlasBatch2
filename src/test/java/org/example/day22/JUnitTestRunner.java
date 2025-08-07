// JUnitCore runner to execute test classes
package org.example.day22;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitTestRunner {
        public static void main(String[] args) {
            Result res = JUnitCore.runClasses(JUnitTestCase01.class);
            for (Failure fobj : res.getFailures()) {
                System.out.println("Failure case: "+ fobj.toString());
            }
            System.out.println("Status: "+res.wasSuccessful());
        }
}
