package org.example.day32;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// loading data to our DynamoDB table
public class LoadingData02 {
    public static void main(String[] args) throws Exception {
        // using theb Aws credentials
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("fakeaccess", "fakeaccess");

        // create a DynamoDb client
        DynamoDbClient client = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8001"))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
        System.out.println("connection created successfully");
        String tableName = "Employees02";

        //object Mapper
        ObjectMapper mapper = new ObjectMapper();

        //giving input stream of data
        InputStream stream = LoadingData02.class.getClassLoader()
                .getResourceAsStream(("Employee.json"));
        System.out.println("the json file in the input stream");
        JsonNode node = mapper.readTree(stream);

        Iterator<JsonNode> iterator = node.elements();

        while (iterator.hasNext()) {
            JsonNode Jsonnode2 = iterator.next();
            Map<String, AttributeValue> item = new HashMap<>();
            item.put("ID", AttributeValue.builder().n(Jsonnode2.get("ID").asText()).build());
            item.put("Name", AttributeValue.builder().s(Jsonnode2.get("Name").asText()).build());
            item.put("Address", AttributeValue.builder().s(Jsonnode2.get("Address").asText()).build());

            PutItemRequest request = PutItemRequest.builder()
                    .tableName(tableName)
                    .item(item)
                    .build();

            client.putItem(request);
            System.out.println(" loading the data to the table");
        }
        client.close();
        System.out.println("closing client connection");
    }
}

