// Delete table in DynamoDB Local

package org.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DeleteTableRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

import java.net.URI;

public class Task03 {
    public static void main(String[] args) {
        String tableName = "Employees01";
        System.out.println("Delete table: " + tableName + " from DynamoDB");

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeAccesskey", "fakeSecretKey");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        try {
            DeleteTableRequest deleteRequest = DeleteTableRequest.builder()
                    .tableName(tableName)
                    .build();

            client.deleteTable(deleteRequest);
            System.out.println("Table " + tableName + " deleted successfully.");
        } catch (ResourceNotFoundException e) {
            System.out.println("Table " + tableName + " does not exist.");
        } catch (Exception e) {
            System.err.println("Failed to delete table: " + e.getMessage());
        } finally {
            client.close();
        }
    }
}
