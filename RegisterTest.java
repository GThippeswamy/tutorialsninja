package Tests;

import org.testng.annotations.Test;
import Page.RegisterPage;
import Base.BaseClass;

public class RegisterTest extends BaseClass {

    @Test
    public void process() {

        RegisterPage register = new RegisterPage(BaseClass.driver);

        register.clickMyAccount();
        register.clickRegister();
        register.registerUser(
                "radha", "krishna", "thippeswamygolla46@gmail.com", "9398473184", "thippi46@masai");
    }
}
