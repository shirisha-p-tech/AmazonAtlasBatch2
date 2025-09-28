package org.example.mobilestore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import org.example.mobilestore.mainapp.CustomTestSummaryListener;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
//import org.junit.platform.launcher.LauncherFactory;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.engine.discovery.DiscoverySelectors;

@SpringBootApplication
public class MobileApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("org.example.mobilestore.test"))
                .build();

        Launcher launcher = org.junit.platform.launcher.core.LauncherFactory.create();
      //  CustomTestSummaryListener listener = new CustomTestSummaryListener();
        // launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
}
