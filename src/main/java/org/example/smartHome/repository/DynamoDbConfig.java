package org.example.smartHome.repository;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

/**
 * Configures the DynamoDB client.
 * Supports both:
 *  - Local DynamoDB (NoSQL Workbench or Docker)
 */
public class DynamoDbConfig {

    public static DynamoDbEnhancedClient getEnhancedClient() {
        // Get endpoint from environment variable if running inside Docker
        String endpoint = System.getenv("DYNAMO_ENDPOINT");

        // Fallback for local IntelliJ or non-container execution
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = "http://localhost:8000";
        }

        System.out.println("[INFO] Connecting to DynamoDB endpoint: " + endpoint);

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("dummyKey", "dummySecret")
                ))
                .build();

        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
    }
}
