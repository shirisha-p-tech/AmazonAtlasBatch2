package org.example.day32;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

public class ScanData {

    public static void main(String[] args) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeaccess", "fakeaccess");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8001"))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        String tableName = "Employees02";

        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse scanResponse = client.scan(scanRequest);

            List<Map<String, AttributeValue>> items = scanResponse.items();

            System.out.println("Scan results:");
            for (Map<String, AttributeValue> item : items) {
                System.out.println("Item: ");
                for (Map.Entry<String, AttributeValue> entry : item.entrySet()) {
                    String key = entry.getKey();
                    AttributeValue value = entry.getValue();

                    if (key.equals("ID") && value.n() != null) {
                        System.out.println(entry.getKey() + ": " + value.n());
                    } else if (key.equals("Name") && value.s() != null) {
                        System.out.println(entry.getKey() + ": " + value.s());
                    } else if (key.equals("Address") && value.s() != null) {
                        System.out.println(entry.getKey() + ": " + value.s());
                    }
                }
                System.out.println("--------------------");
            }
        } catch (DynamoDbException e) {
            System.err.println("Error scanning table: " + e.getMessage());
        } finally {
            client.close();
        }
    }
}
