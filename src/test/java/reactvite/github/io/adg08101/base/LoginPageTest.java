package reactvite.github.io.adg08101.base;

import org.testng.annotations.Test;
import reactvite.github.io.adg08101.pages.LoginPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.navigate();

        login.enterUser("valid-user");
        login.enterEmail("validuser@example.com");
        login.enterPassword("validPassword123");
        login.clickLogin();

        assertTrue(login.getUrl().indexOf("shopping") > 0);
    }

    @Test
    public void testInvalidLoginShowsErrorMessage() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.navigate();

        login.clickLogin();

        assertEquals(login.getErrors().size(), 3);
    }
}
