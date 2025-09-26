package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By MyAccount = By.xpath("//span[normalize-space()='My Account']");
    By login = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");
    By email = By.xpath("//input[@id='input-email']");
    By password = By.xpath("//input[@id='input-password']");
    By lbtn = By.xpath("//input[@value='Login']");

    public void MyAccount() {
        driver.findElement(MyAccount).click();
    }

    public void Login() {
        driver.findElement(login).click();

    }

    public void loginProcess(String mail, String pass) {
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(lbtn).click();
    }

}
