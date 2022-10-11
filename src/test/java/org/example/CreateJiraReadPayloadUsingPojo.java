package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class CreateJiraReadPayloadUsingPojo {
    private static JiraServiceRequestPojo jiraServiceRequestPojo;

    public static void main(String[] args) throws IOException {


        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");

        Path path=Paths.get("./src/test/java/resources/JiraRequest.json");
        byte[] bytes=Files.readAllBytes(path);
        ObjectMapper mapper= new ObjectMapper();
        JiraServiceRequestPojo jiraServiceRequestPojoObj= mapper.readValue(bytes,JiraServiceRequestPojo.class);

        jiraServiceRequestPojoObj.getFields().getProject().setKey("TES");




        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/";
        RestAssured.authentication=RestAssured.preemptive().basic("yamuna.jayaraman@gmail.com", "X4By27BOMZJw9vtofoJ27FEC");

        CreateJiraResponse issue = RestAssured.given().log().all().
                headers(headerMap).body(jiraServiceRequestPojoObj).
                when().post("issue").
                then().log().all().
                statusCode(201).extract().response().as(CreateJiraResponse.class);
        String key=issue.getFields().getProject().getKey();
        System.out.println(key);


    }
}
