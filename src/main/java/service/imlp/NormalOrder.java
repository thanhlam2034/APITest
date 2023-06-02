package service.imlp;

import io.restassured.response.Response;
import model.User;
import org.json.simple.JSONObject;
import service.INormalOrder;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class NormalOrder implements INormalOrder {
    @Override
    public Response createNormalOrder(User user) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bankCode","9999");
        jsonObject.put("orderPrice", 35000);
        jsonObject.put("orderQuantity",100);
        jsonObject.put("orderType","LO");
        jsonObject.put("stockCode","VCI");
        jsonObject.put("subNum","00");

        Logger.getLogger(user.getToken());
        Response response = given().
                header("Authorization", "Bearer " + user.getToken()).
                header("Content-Type", "application/json").
                body(jsonObject).
                when().
                post("https://mt-qc.vietcap.com.vn/api/order-service/v1/order?type=1").
                then().
                statusCode(200).log().all().
                extract().response();
        return response;
    }

    @Override
    public void editNormalOrder(User user) {

    }

    @Override
    public void deleteNormalOrder(User user) {

    }
}
