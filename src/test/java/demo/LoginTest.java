package demo;

import constant.ConstantVariable;
import model.User;
import org.testng.annotations.Test;
import service.ILogin;
import service.imlp.Login;

public class LoginTest {
    @Test(priority = 1)
    public void testLogin(){
        ILogin login = new Login();
        User userLamNguyen = User.builder().username(ConstantVariable.USERNAME).password(ConstantVariable.PASSWORD).build();
        login.loginVietCap(userLamNguyen);
        login.sendSmsOTP(userLamNguyen);
    }
}
