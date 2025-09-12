package org.example.day32;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.Map;

public class UpdateData {

    public static void main(String[] args) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeaccess", "fakeaccess");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8001"))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        String tableName = "Employees02";
        String idToUpdate = "1001";  // ID of the item to update
        String newAddress = "Canada";  // New address to update

        try {
            UpdateItemRequest updateItemRequest = UpdateItemRequest.builder()
                    .tableName(tableName)
                    .key(

                            Map.of("ID", AttributeValue.builder().n(idToUpdate).build())
                    )
                    .updateExpression("SET Address = :address")  // Update address attribute
                    .expressionAttributeValues(
                            Map.of(":address", AttributeValue.builder().s(newAddress).build())
                    )
                    .build();

            client.updateItem(updateItemRequest);
            System.out.println("\nItem updated successfully.");
            System.out.println("\'Address\' of ID " + idToUpdate + " got updated to \'" + newAddress + "\'.");
        } catch (DynamoDbException e) {
            System.err.println("Error updating item: " + e.getMessage());
        } finally {
            client.close();
        }
    }
}

