package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Page.WhislistPage;

public class WhislistTest extends BaseClass {

    @Test
    void process() throws InterruptedException {
        WhislistPage whislist = new WhislistPage(BaseClass.driver);
        whislist.WhlistList();
    }
}
