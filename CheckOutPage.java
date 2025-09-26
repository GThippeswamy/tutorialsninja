package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckOutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By cartButton = By.xpath("//span[@id='cart-total']");
    By viewCart = By.xpath("//strong[normalize-space()='View Cart']");
    By checkoutBtn = By.xpath("//a[contains(text(),'Checkout')]");
    By fname = By.id("input-payment-firstname");
    By lname = By.id("input-payment-lastname");
    By emailInput = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By company = By.id("input-payment-company");
    By ad1 = By.id("input-payment-address-1");
    By ad2 = By.id("input-payment-address-2");
    By city = By.id("input-payment-city");
    By postCode = By.id("input-payment-postcode");
    By country = By.id("input-payment-country");
    By state = By.id("input-payment-zone");
    By continueBillingBtn = By.id("button-guest");
    By deliveryContinueBtn = By.id("button-shipping-address");
    By deliveryComment = By.className("form-control");
    By deliveryMethodBtn = By.xpath("//input[@id='button-shipping-method' and @class='btn btn-primary']");
    By paymentComment = By.xpath("//div[@id='collapse-payment-method']//textarea[@name='comment']");
    By termsCheckbox = By.name("agree");
    By paymentMethodBtn = By.id("button-payment-method");
    By confirmOrderBtn = By.id("button-confirm");

    By guestRadio = By.xpath("//input[@type='radio' and @value='guest']");
    By loginEmail = By.xpath("//input[@id='input-email']");
    By passwordInput = By.xpath("//input[@id='input-password']");
    By loginBtn = By.id("button-account");

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public void checkOutOption(String email, String pass) {
        driver.findElement(guestRadio).click();
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public void enterBillingDetails(String fn, String ln, String EMAIL, String Tel, String com, String adLine1,
            String adLine2, String cityName, String pin) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fname)).sendKeys(fn);
        driver.findElement(lname).sendKeys(ln);
        driver.findElement(emailInput).sendKeys(EMAIL);
        driver.findElement(telephone).sendKeys(Tel);
        driver.findElement(company).sendKeys(com);
        driver.findElement(ad1).sendKeys(adLine1);
        driver.findElement(ad2).sendKeys(adLine2);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(postCode).sendKeys(pin);
    }

    public void selectCountryState() {
        Select selectCountry = new Select(wait.until(ExpectedConditions.elementToBeClickable(country)));
        selectCountry.selectByVisibleText("India");

        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement stateDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(state));
                Select selectState = new Select(stateDropdown);
                wait.until(driver -> selectState.getOptions().size() > 1);
                selectState.selectByIndex(1);
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                attempts++;
            }
        }
        System.out.println("Select state && contry");
    }

    public void continueBilling() {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBillingBtn));
                if (btn.isDisplayed() && btn.isEnabled()) {
                    btn.click();
                    break;
                }
            } catch (org.openqa.selenium.StaleElementReferenceException
                    | org.openqa.selenium.ElementClickInterceptedException e) {
                attempts++;
            }
        }
        System.out.println("continueBilling");
    }

    public void continueDelivery() {
        int attempts = 0;
        while (attempts < 5) {
            try {
                wait.until(driver -> {
                    WebElement deliveryBtn = driver.findElement(deliveryContinueBtn);
                    return deliveryBtn.isDisplayed() && deliveryBtn.isEnabled() ? deliveryBtn : null;
                }).click();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException
                    | org.openqa.selenium.ElementClickInterceptedException | org.openqa.selenium.TimeoutException e) {
                attempts++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        System.out.println("continueDelivery");
    }

    public void enterDeliveryMethod(String msg) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryComment));
                comment.clear();
                comment.sendKeys(msg);
                WebElement methodBtn = wait.until(ExpectedConditions.elementToBeClickable(deliveryMethodBtn));
                if (methodBtn.isDisplayed() && methodBtn.isEnabled()) {
                    methodBtn.click();
                    break;
                }
            } catch (org.openqa.selenium.StaleElementReferenceException
                    | org.openqa.selenium.ElementClickInterceptedException e) {
                attempts++;
            }
        }
        System.out.println("enterDeliveryMethod");
    }

    public void enterPaymentMethod(String msg) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentComment));
                comment.clear();
                comment.sendKeys(msg);
                WebElement terms = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
                if (!terms.isSelected())
                    terms.click();
                WebElement payBtn = wait.until(ExpectedConditions.elementToBeClickable(paymentMethodBtn));
                if (payBtn.isDisplayed() && payBtn.isEnabled()) {
                    payBtn.click();
                    break;
                }
            } catch (org.openqa.selenium.StaleElementReferenceException
                    | org.openqa.selenium.ElementClickInterceptedException e) {
                attempts++;
            }
        }
        System.out.println(" enterPaymentMethod");
    }

    public void confirmOrder() {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
                if (btn.isDisplayed() && btn.isEnabled()) {
                    btn.click();
                    break;
                }
            } catch (org.openqa.selenium.StaleElementReferenceException
                    | org.openqa.selenium.ElementClickInterceptedException e) {
                attempts++;
            }
        }
    }
}
