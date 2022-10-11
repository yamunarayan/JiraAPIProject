package org.example;

import io.restassured.RestAssured;

import java.util.HashMap;

public class CreateJiraRequestUsingBuilder {
    public static void main(String[] args){

        HashMap<String,String>headerMap= new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");

        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/";
        RestAssured.authentication=RestAssured.preemptive().basic("yamuna.jayaraman@gmail.com", "X4By27BOMZJw9vtofoJ27FEC");
        
        JiraServiceRequestUsingBuilder.Fields.Project jiraServiceRequestUsingBuilderObj=
                JiraServiceRequestUsingBuilder.Fields.Project.builder().key("TES").build();

        CreateJiraResponse issue = RestAssured.given().log().all().
                headers(headerMap).body(jiraServiceRequestUsingBuilderObj).
                when().post("issue").
                then().log().all().
                statusCode(201).extract().response().as(CreateJiraResponse.class);

        String key = issue.getFields().getProject().getKey();
        System.out.println(key);
    }
}
