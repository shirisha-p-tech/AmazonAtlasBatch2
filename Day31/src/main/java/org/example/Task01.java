// Delete item from table

package org.example;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;


public class Task01 {
    public static void main(String[] args) {

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeAccesskey","fakeSecretKey");


        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();


        String tableName = "Employees01";
        int delId = 102;

        System.out.println("Delete item of id " + delId + " from table in DynamoDB");
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("ID", AttributeValue.builder().n(String.valueOf(delId)).build());


        GetItemResponse getResponse =client.getItem(builder -> builder.tableName(tableName).key(item));
        client.deleteItem(builder -> builder.tableName(tableName).key(item));


        System.out.println("Items after deletion");
        ScanRequest req = ScanRequest.builder().tableName(tableName).build();
        ScanResponse resp = client.scan(req);


        for(Map<String, AttributeValue> dbitem : resp.items()) {
            System.out.println(dbitem);
        }
        client.close();


    }
}
