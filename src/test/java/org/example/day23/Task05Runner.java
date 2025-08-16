package org.example.day23;


// TestSuiteRunner to run the suite and output the results

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
        Task05Test01.class,
        Task05Test02.class,
        Task06Test.class
})
public class Task05Runner {

    // No code needed here as the suite will automatically run the selected test classes
    // Task05Runner is only used by JUnit to collect and launch tests — it is not instantiated or executed like a regular class.
}


