package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.HashMap;

public class GetJira {
    public static void main(String[] args){

        HashMap<String,String> headerMap= new HashMap<>();
        headerMap.put("Content-Type","application/json");
        headerMap.put("Accept","application/json");

        RestAssured.baseURI="https://pavi143.atlassian.net";
        RestAssured.basePath="/rest/api/3/issue";
        RestAssured.authentication=RestAssured.preemptive().
                basic("yamuna.jayaraman@gmail.com","X4By27BOMZJw9vtofoJ27FEC");

        Response response = RestAssured.given().log().all().
                headers(headerMap).
                when().get("10096").
                then().log().all().
                statusCode(200).extract().response();
        response.then().body("key", Matchers.is("TES-97"));
        JsonPath jsonPath = response.jsonPath();
       String key= jsonPath.get("key");
        System.out.println(key);
        System.out.println(response.prettyPrint());

    }
}
