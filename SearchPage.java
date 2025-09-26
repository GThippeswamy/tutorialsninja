package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By search = By.xpath("//input[@placeholder='Search']");
    By desktops = By.xpath("//a[normalize-space()='Desktops']");
    By subMac = By.xpath("//a[normalize-space()='Mac (1)']");
    By firstProduct = By.xpath("//img[@alt='HP Banner']");
    By product = By.xpath("//div[@class='caption']//a[contains(text(),'HP LP3065')]");
    By calender = By.xpath("//input[@id='input-option225']");
    By quality = By.xpath("//input[@id='input-quantity']");
    By AddToCart = By.xpath("//button[@id='button-cart']");

    public void Search(String product) {
        driver.findElement(search).sendKeys(product);
    }

    public void DeskTop() {
        driver.findElement(desktops).click();
    }

    public void subMac() {
        driver.findElement(subMac).click();
        driver.findElement(firstProduct).click();
    }

    public void ProductDetails(String Calender) {
        driver.findElement(product).click();
        driver.findElement(calender).sendKeys(Calender);
        WebElement change = wait.until(ExpectedConditions.elementToBeClickable(quality));
        change.clear();
        change.sendKeys("2");

    }

    public void addTocart() {
        driver.findElement(AddToCart).click();
    }

}
