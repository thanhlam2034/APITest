package service.imlp;

import service.IPriceBoard;
import static io.restassured.RestAssured.*;

public class PriceBoard implements IPriceBoard {

    @Override
    public void priceBoard() {
        given().
                when().
                get("https://mt-qc.vietcap.com.vn/api/price/symbols/getAll").
                then().
                statusCode(200).log().all().
                extract().response();
    }

    @Override
    public void getListBoard() {
        given().
                when().
                get("https://mt-qc.vietcap.com.vn/api/price/symbols/getAll").
                then().
                statusCode(200).log().all().
                extract().response();
    }
}
