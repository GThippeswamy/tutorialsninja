package Tests;

import org.testng.annotations.Test;
import Base.BaseClass;
import Page.SearchPage;

public class SearchTest extends BaseClass {

    @Test
    void process() {
        SearchPage searchPage = new SearchPage(BaseClass.driver);
        searchPage.DeskTop();
        searchPage.subMac();
        searchPage.ProductDetails("2000-01-01");
        searchPage.addTocart();

    }
}
