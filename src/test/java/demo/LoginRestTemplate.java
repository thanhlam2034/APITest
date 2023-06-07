package demo;

import org.testng.annotations.Test;
import service.ILoginRestTemplate;

public class LoginRestTemplate {
    @Test
    public void loginRestTemplateUserLamNguyen(){
        ILoginRestTemplate loginRestTemplate = new service.imlp.LoginRestTemplate();
        loginRestTemplate.loginByNumber();
    }
}
