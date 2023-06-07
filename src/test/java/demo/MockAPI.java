package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MockAPI {
    @Test
    void Test_1(){
        baseURI = "http://localhost:3000/";

        given().param("name", "Automation")
                .get("/subjects").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    void Test_2_POST(){
        baseURI = "http://localhost:3000/";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname", "Lam3");
        jsonObject.put("lastname", "Nguyen3");
        jsonObject.put("subjectId", 1);

        given().header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

}
