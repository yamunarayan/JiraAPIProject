package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
public class CreateJiraWithStringPayload {
    public static void main(String[] args){
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

        HashMap<String,String> headerMap= new HashMap<String, String>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");
        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/";
        RestAssured.authentication=RestAssured.preemptive().
                basic("yamuna.jayaraman@gmail.com","X4By27BOMZJw9vtofoJ27FEC");

        Response issue = RestAssured.given().log().all().
                headers(headerMap).
                body(body).
                when().post("issue").
                then().log().all().
                statusCode(201).extract().response();
        System.out.println(issue.prettyPrint());
        issue.then().body("key",Matchers.containsString("TES"));
       File file =new File("./src/test/java/JiraResponse.json");
       issue.then().body(JsonSchemaValidator.matchesJsonSchema(file));




    }
}
