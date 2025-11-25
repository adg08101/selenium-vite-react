package test;

import org.testng.annotations.Test;
import reactvite.github.io.adg08101.base.BaseTest;
import reactvite.github.io.adg08101.pages.LoginPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage login = new LoginPage(driver);
        login.openAndNavigate();

        login.enterUser("valid-user");
        login.enterEmail("validuser@example.com");
        login.enterPassword("validPassword123");
        login.clickLogin();

        assertTrue(login.getUrl().indexOf("shopping") > 0);
    }

    @Test
    public void testInvalidLoginShowsErrorMessage() {
        LoginPage login = new LoginPage(driver);
        login.openAndNavigate();

        login.clickLogin();

        assertEquals(login.getErrors().size(), 3);
    }
}
