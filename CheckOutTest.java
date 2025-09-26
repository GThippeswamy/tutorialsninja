
package Tests;

import org.testng.annotations.Test;
import Base.BaseClass;
import Page.CheckOutPage;
import Page.SearchPage;

public class CheckOutTest extends BaseClass {

    @Test
    public void testCheckout() throws InterruptedException {
        SearchPage search = new SearchPage(BaseClass.driver);
        CheckOutPage checkout = new CheckOutPage(BaseClass.driver);

        search.DeskTop();
        search.subMac();
        search.ProductDetails("2000-01-01");
        search.addTocart();

        checkout.goToCheckout();
        checkout.checkOutOption("thippeswamygolla46@gmail.com", "thippi46@masai");

        checkout.enterBillingDetails(
                "Radha",
                "Krishna",
                "thippeswamygolla46@gmail.com",
                "9398473184",
                "ABC Ltd",
                "Street1",
                "Street2",
                "Hyderabad",
                "500001");

        checkout.selectCountryState();
        checkout.continueBilling();
        checkout.continueDelivery();
        checkout.enterDeliveryMethod("Please deliver carefully.");
        checkout.enterPaymentMethod("Paid online.");
        checkout.confirmOrder();
    }
}
