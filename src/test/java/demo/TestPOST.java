package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPOST {
    @Test
    void Test_1(){
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201);
    }

    @Test
    void Test_2_Put(){
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }
    @Test
    void Test_3_Patch(){
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    void Test_4_Delete(){

        given().
                when().
                delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
