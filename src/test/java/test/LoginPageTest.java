package test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import reactvite.github.io.adg08101.base.BaseTest;
import reactvite.github.io.adg08101.pages.LoginPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @Test (priority = 0, description = "Test success login")
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.openAndNavigate();

        login.enterUser("valid-user");
        login.enterEmail("validuser@example.com");
        login.enterPassword("validPassword123");
        login.selectRandomCountry();
        login.clickLogin();

        assertTrue(login.getUrl().indexOf("shopping") > 0);
    }

    @Test (description = "Test no success login")
    public void testInvalidLoginShowsErrorMessage() throws IOException {
        LoginPage login = new LoginPage(driver);
        login.openAndNavigate();

        login.clickLogin();

        try {
            assertEquals(login.getErrors().size(), 4);
        } catch (Exception e) {
            takeScreenshotProcedure(Reporter.getCurrentTestResult().getName());
        }
    }
}
