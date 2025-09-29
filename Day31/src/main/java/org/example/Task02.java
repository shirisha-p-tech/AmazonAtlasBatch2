// Update only Name in table (with null checks)

// If item id present, updates attribute value accordingly.
// If item id not present, it will create one, give values to attributes accordingly.
// If user misses any attribute value, it will print N/A.

//In below table 102 id isn't present,hence creates one and updates only Name to "Pooja" and Address would be "N/A"

package org.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Task02 {
    public static void main(String[] args) {
        int updateId = 102; // ID of the employee to update
        String newName = "Pooja"; // new name

        System.out.println("Update Name by id " + updateId + " in table DynamoDB");

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeAccesskey", "fakeSecretKey");

        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        String tableName = "Employees01";

        // Key of the item to update
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("ID", AttributeValue.builder().n(String.valueOf(updateId)).build());

        // Define update expression (only Name)
        Map<String, String> expressionAttrNames = new HashMap<>();
        expressionAttrNames.put("#N", "Name");

        Map<String, AttributeValue> expressionAttrValues = new HashMap<>();
        expressionAttrValues.put(":newName", AttributeValue.builder().s(newName).build());

        UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .updateExpression("SET #N = :newName")
                .expressionAttributeNames(expressionAttrNames)
                .expressionAttributeValues(expressionAttrValues)
                .build();

        client.updateItem(updateRequest);

        // Print all items after update
        System.out.println("Items after update");
        ScanRequest req = ScanRequest.builder().tableName(tableName).build();
        ScanResponse resp = client.scan(req);

        for (Map<String, AttributeValue> dbitem : resp.items()) {
            String id = dbitem.containsKey("ID") ? dbitem.get("ID").n() : "N/A";
            String name = dbitem.containsKey("Name") ? dbitem.get("Name").s() : "N/A";
            String address = dbitem.containsKey("Address") ? dbitem.get("Address").s() : "N/A";

            System.out.println("{ID=" + id + ", Name=" + name + ", Address=" + address + "}");
        }

        client.close();
    }
}
