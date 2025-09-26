package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhislistPage {
    WebDriver driver;

    public WhislistPage(WebDriver driver) {
        this.driver = driver;
    }

    By whilist = By.xpath("//a[@id='wishlist-total']");
    By continueBtn = By.xpath("//a[@class='btn btn-primary']");

    public void WhlistList() throws InterruptedException {
        driver.findElement(whilist).click();
        driver.findElement(continueBtn).click();
        Thread.sleep(1000);
    }
}
