package demo;

import constant.ConstantVariable;
import constant.EnvironmentVariables;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.ILogin;
import service.INormalOrder;
import service.imlp.Login;
import service.imlp.NormalOrder;

public class LoginTest {

//    @Test(priority = 1)
//    public void testLogin() throws Exception {
//
//        User userLamNguyen = User.builder().username(System.getenv("USER")).password(System.getenv("PASS")).build();
//        ILogin login = new Login();
//        login.loginVietCap(userLamNguyen);
//        login.sendSmsOTP(userLamNguyen);

//    }
//
    @Test(priority = 2)
    public void createNormalOrder(){
        User userLamNguyen = User.builder().username(System.getenv("USER")).password(System.getenv("PASS")).build();
        ILogin login = new Login();
        INormalOrder normalOrder = new NormalOrder();
        login.loginVietCap(userLamNguyen);
        Response responseNormalOrder = normalOrder.createNormalOrder(userLamNguyen);
        int statusCode = responseNormalOrder.statusCode();
        Assert.assertTrue(statusCode == 200);
    }

}
