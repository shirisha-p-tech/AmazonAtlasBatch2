// Launcher code
package org.example;

import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

public class DemoTest003JunitLauncher {

    private static final Logger logger = LoggerFactory.getLogger(DemoTest003JunitLauncher.class);

    public static void main(String[] args) {
        // Listener WITHOUT executionFinished override
        TestExecutionListener customListener = new TestExecutionListener() {
            @Override
            public void executionStarted(TestIdentifier testIdentifier) {
                logger.info("Test Started: {}", testIdentifier.getDisplayName());
            }
        };

        // Create test discovery request
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectClass(SampleTests.class) // Add more classes if needed
                )
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();

        launcher.registerTestExecutionListeners(customListener, summaryListener);

        launcher.execute(request);

        TestExecutionSummary summary = summaryListener.getSummary();
        printTestResults(summary);
    }

    private static void printTestResults(TestExecutionSummary summary) {
        logger.info("\nTest Execution Summary:");
        logger.info("Tests Found: {}", summary.getTestsFoundCount());
        logger.info("Tests Started: {}", summary.getTestsStartedCount());
        logger.info("Tests Skipped: {}", summary.getTestsSkippedCount());
        logger.info("Tests Aborted: {}", summary.getTestsAbortedCount());
        logger.info("Tests Succeeded: {}", summary.getTestsSucceededCount());
        logger.info("Tests Failed: {}", summary.getTestsFailedCount());
        logger.info("Total Time: {} ms", summary.getTimeFinished() - summary.getTimeStarted());

        if (summary.getTestsFailedCount() > 0) {
            logger.error("\nTest Failures:");
            summary.getFailures().forEach(failure -> {
                logger.error("Failed Test: {}", failure.getTestIdentifier().getDisplayName());
                logger.error("Reason: {}", failure.getException());
            });
        }
    }
}
