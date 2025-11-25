package reactvite.github.io.adg08101.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reactvite.github.io.adg08101.pages.base.BasePage;

import java.util.List;

public class ShoppingPage extends BasePage {
    private By productContainer = By.cssSelector("div[id=root] div[style] div");
    private By formLink = By.xpath("//*[text()='Shopping App']");
    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    public void openAndNavigate() {
        openUrl("https://adg08101.github.io/react-vite");
        navigate(formLink);
    }

    public void getProducts() {
        List<WebElement> container = driver.findElements(productContainer);

        for (WebElement item : container) {
            println(item.getText());
        }
    }
}
