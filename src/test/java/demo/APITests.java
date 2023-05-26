package demo;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITests {
    @Test
    void test1(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.body().asString());
    }

    @Test
    void test2(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7));
    }
}
