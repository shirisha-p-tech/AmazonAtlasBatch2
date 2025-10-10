package org.example.smartHome.repository;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

/**
 * Configures the DynamoDB client to connect to DynamoDB Local running at localhost:8000.
 * Uses dummy credentials since DynamoDB Local does not require real AWS authentication.
 */
public class DynamoDbConfig {

    // Returns an enhanced DynamoDB client instance
    public static DynamoDbEnhancedClient getEnhancedClient() {
        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")) // DynamoDB Local endpoint
                .region(Region.US_EAST_1) // region (not important for local)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("dummyKey", "dummySecret"))) // fake keys
                .build();

        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
    }
}
