package reactvite.github.io.adg08101.base;

import org.testng.annotations.Test;
import reactvite.github.io.adg08101.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageLoadsCorrectly() {
        HomePage home = new HomePage(driver);
        home.navigateToHome();
        assertTrue(home.isSomeElementDisplayed());
    }
}
