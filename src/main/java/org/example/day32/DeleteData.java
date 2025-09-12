package org.example.day32;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DeleteData {

    public static void main(String[] args) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeaccess", "fakeaccess");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8001"))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        String tableName = "Employees02";
        String idToDelete = "1002";  // ID of the item to delete

        try {
            Map<String, AttributeValue> key = new HashMap<>();
            key.put("ID", AttributeValue.builder().n(idToDelete).build());

            // Prepare the delete request
            DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder()
                    .tableName(tableName)
                    .key(key)
                    .build();

            // Execute the delete operation
            client.deleteItem(deleteItemRequest);


            System.out.println("\nItem with ID " + idToDelete + " deleted successfully.");
        } catch (DynamoDbException e) {
            System.err.println("Error deleting item: " + e.getMessage());
        } finally {
            client.close();
        }
    }
}

