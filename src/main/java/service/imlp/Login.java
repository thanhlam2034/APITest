package service.imlp;

import constant.ConstantVariable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.User;
import org.json.simple.JSONObject;
import service.ILogin;

import java.util.logging.Logger;

import static io.restassured.RestAssured.*;

public class Login implements ILogin {
    @Override
    public void loginVietCap(User user) {
        Response response = given().
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Accept", "application/json").
                formParam("grant_type", "password").
                formParam("client_id", "master-trade-fe").
                formParam("username", user.getUsername()).
                formParam("password", user.getPassword()).
                when().
                post(System.getenv("ENDPOINT_KEYCLOAK_QC") + "/auth/realms/demo/protocol/openid-connect/token").
                then().
                statusCode(200).log().all().
                extract().response();

        JsonPath jsonPath = response.jsonPath();
        user.setToken(jsonPath.get("access_token").toString());
        Logger.getLogger(user.getToken());
    }

    @Override
    public void sendSmsOTP(User user) {
        Logger.getLogger(user.getToken());
        Response response = given().
                header("Authorization", "Bearer " + user.getToken()).
                when().
                get(System.getenv("ENDPOINT_KEYCLOAK_QC") + "/auth/realms/demo/otp-service/sendSmsOtp").
                then().
                statusCode(200).log().all().
                extract().response();
    }

    @Override
    public void validateSmsOTP(User user, String sms) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("otp", sms);
        Response response = given().
                header("Authorization", "Bearer " + user.getToken()).
                body(jsonObject).
                when().
                post(System.getenv("ENDPOINT_KEYCLOAK_QC") + "/auth/realms/demo/otp-service/validateOtp").
                then().
                statusCode(200).log().all().
                extract().response();
    }
}

