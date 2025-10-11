package org.example.smartHome.repository;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class DynamoDbConfig {

    // Returns an enhanced DynamoDB client instance
    public static DynamoDbEnhancedClient getEnhancedClient() {
        // Check for environment variable
        String endpoint = System.getenv("DYNAMODB_ENDPOINT");

        if (endpoint == null || endpoint.isBlank()) {
            // No endpoint explicitly set - decide based on environment
            // Check if running inside Docker via an environment variable IS_DOCKER (optional)
            String isDocker = System.getenv("IS_DOCKER");
            if ("true".equalsIgnoreCase(isDocker)) {
                endpoint = "http://host.docker.internal:8000";  // inside Docker, talk to host machine
            } else {
                endpoint = "http://localhost:8000";  // default for IntelliJ or local run
            }
        }


        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("dummyKey", "dummySecret")))
                .build();

        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
    }
}
