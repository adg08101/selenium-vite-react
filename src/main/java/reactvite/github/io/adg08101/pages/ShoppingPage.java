package reactvite.github.io.adg08101.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import reactvite.github.io.adg08101.pages.base.BasePage;

import java.util.List;
import java.util.Random;

public class ShoppingPage extends BasePage {
    private final By productContainer = By.cssSelector("div[id=root] div[style] div");
    private final By formLink = By.xpath("//*[text()='Shopping App']");
    private final By shopBtn = By.xpath("//*[text()='Buy']");
    private final By addBtn = By.xpath("//*[text()='+']");
    private final By removeBtn = By.xpath("//*[text()='-']");
    private List<WebElement> productList;
    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    public void openAndNavigate() {
        openUrl("https://adg08101.github.io/react-vite");
        navigate(formLink);
    }

    public void loadProducts() {
        List<WebElement> container =
                getWait().until(ExpectedConditions.
                        visibilityOfAllElementsLocatedBy(productContainer));

        this.setProductList(container);
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public void setProductList(List<WebElement> productList) {
        this.productList = productList;
    }

    public String shopZeroQuantity() {
        int prodIndex = new Random().nextInt(0, getProductList().size() - 1);
        WebElement product = getProductList().get(prodIndex);

        product.findElement(shopBtn).click();

        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());

        return alert.getText();
    }
}
