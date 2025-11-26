package test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import reactvite.github.io.adg08101.base.BaseTest;
import reactvite.github.io.adg08101.pages.ShoppingPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ShoppingPageTest extends BaseTest {
    @Test (description = "Test zero items shop")
    public void testSuccessfulShop() throws IOException {
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.openAndNavigate();

        shoppingPage.loadProducts();

        assertTrue(shoppingPage.shopZeroQuantity().contains("greater than 0"));

        takeScreenshotProcedure(Reporter.getCurrentTestResult().getName());
    }
}
