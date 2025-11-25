package test;

import org.testng.annotations.Test;
import reactvite.github.io.adg08101.base.BaseTest;
import reactvite.github.io.adg08101.pages.ShoppingPage;

import static org.testng.Assert.assertTrue;

public class ShoppingPageTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.openAndNavigate();

        // assertTrue(shoppingPage.getProducts().size() > 0);

        shoppingPage.getProducts();

        // String message = "The size of items is: ".concat(String.valueOf(shoppingPage.getProducts().size()));
        // shoppingPage.println(message);

        Thread.sleep(3000);
    }
}
