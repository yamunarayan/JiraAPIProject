package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class E2E {
    static String key;
    @Test
    public static void createJira() throws IOException {
        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");

        Path path= Paths.get("./src/test/java/resources/JiraRequest.json");
        byte[] bytes= Files.readAllBytes(path);
        ObjectMapper mapper= new ObjectMapper();
        JiraServiceRequestF jiraServiceRequestFObj= mapper.readValue(bytes,JiraServiceRequestF.class);

        jiraServiceRequestFObj.getFields().getProject().setKey("TES");
        jiraServiceRequestFObj.getFields().getIssuetype().setName("Bug");
        jiraServiceRequestFObj.getFields().setSummary("Sample issue summary _Using File From jira");
        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/";
        RestAssured.authentication=RestAssured.preemptive().basic("yamuna.jayaraman@gmail.com", "3SltbaEb5owKGfmV6l1D1F0D");

        CreateJiraResponse issue = RestAssured.given().log().all().
                headers(headerMap).body(jiraServiceRequestFObj).
                when().post("issue").
                then().log().all().
                statusCode(201).extract().response().as(CreateJiraResponse.class);

         key = issue.getKey();

    }


    @Test(dependsOnMethods = {"createJira"})
    public static void getJira(){
        HashMap<String,String> headerMap= new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");

        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/issue/";
        RestAssured.authentication=RestAssured.preemptive().
                basic("yamuna.jayaraman@gmail.com","3SltbaEb5owKGfmV6l1D1F0D");

        Response response = RestAssured.given().log().all().
                headers(headerMap).
                when().get(key).
                then().log().all().
                statusCode(200).extract().response();
        response.then().body("key", Matchers.is(key));
        JsonPath jsonPath = response.jsonPath();
        String key= jsonPath.get("key");

    }
    @Test(dependsOnMethods = {"getJira"})
    public static void deleteJira(){
        HashMap<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");
        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/";
        RestAssured.authentication=RestAssured.preemptive().basic("yamuna.jayaraman@gmail.com", "3SltbaEb5owKGfmV6l1D1F0D");

        Response response = RestAssured.given().log().all().
                headers(headerMap).
                when().delete("issue/"+ key).
                then().log().all().
                statusCode(204).extract().response();



    }

}
