package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;

public class CreateJiraRequestUsingOM {
    public static void main(String[] args) throws JsonProcessingException {
        String body="{\"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"TES\"\n" +
                "        },\n" +
                "        \"summary\": \"Sample issue summary\",\n" +

                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "            \"type\": \"doc\",\n" +
                "            \"version\": 1,\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"paragraph\",\n" +
                "                    \"content\": [\n" +
                "                        {\n" +
                "                            \"text\": \"description\",\n" +
                "                            \"type\": \"text\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";


        HashMap<String,String>headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> type= new TypeReference<>(){};
        HashMap<String, String> bodyMap= mapper.readValue(body,type);
        bodyMap.put("key","TES");
        bodyMap.put("summary", "Test Summary");
        bodyMap.put("name", "Bug");
        bodyMap.put("type", "paragraph");
        bodyMap.put("text", "description");



        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/";
        RestAssured.authentication=RestAssured.preemptive().
                basic("yamuna.jayaraman@gmail.com","X4By27BOMZJw9vtofoJ27FEC");

        Response issue = RestAssured.given().log().all().
                headers(headerMap).
                body(bodyMap).
                when().post("issue").
                then().statusCode(201).extract().response();
        File file = new File("./src/test/java/JiraResponse.json");
        issue.then().body(JsonSchemaValidator.matchesJsonSchema(file));





    }
}
