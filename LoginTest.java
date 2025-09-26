package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Page.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    void process() {
        LoginPage login = new LoginPage(BaseClass.driver);
        login.MyAccount();
        login.Login();
        login.loginProcess("thippeswamygolla46@gmail.com", "thippi46@masai");
        System.out.println("login successful completed");
    }
}
