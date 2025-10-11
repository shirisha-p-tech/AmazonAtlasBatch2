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
            endpoint = "http://localhost:8000"; // default for IntelliJ
        }

        System.out.println("🔌 Connecting to DynamoDB at: " + endpoint);

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
