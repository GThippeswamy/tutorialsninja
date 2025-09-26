package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By myAccount = By.xpath("//ul[@class='list-inline']//li[@class='dropdown']");
    By registerLink = By.xpath("//a[normalize-space()='Register']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By newsletterYes = By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']");
    By continueBtn = By.xpath("//input[@value='Continue']");

    public void clickMyAccount() {
        driver.findElement(myAccount).click();
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void registerUser(String fname, String lname, String mail, String phoneNumber, String pass) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(telephone).sendKeys(phoneNumber);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(newsletterYes).click();
        driver.findElement(continueBtn).click();
    }
}
