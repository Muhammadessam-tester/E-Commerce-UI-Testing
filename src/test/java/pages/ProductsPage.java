package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    private WebDriver driver;

    private By menuLocator = By.id("react-burger-menu-btn");
    private By logoutLocator = By.id("logout_sidebar_link");
    private By cartIconLocator = By.className("shopping_cart_link");
    private By countInCartLocator = By.className("shopping_cart_badge");
    private By titleLocator = By.className("title");
    private By sortLocator = By.className("product_sort_container");
    private By itemsLocator = By.className("inventory_item_name");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(menuLocator).click();
        driver.findElement(logoutLocator).click();
    }

    public void addToCart(String itemName) {
        String productName = "add-to-cart-" +
                itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(productName)).click();
    }

    public void removeFromTheCart(String itemName) {
        String productName = "remove-"
                + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(productName)).click();
    }

    public void goToCartPage() {
        driver.findElement(cartIconLocator).click();
    }

    public String getPageTitle() {
        return driver.findElement(titleLocator).getText();
    }

    public int getNumOfProductsAddInCartIcon() {
        return Integer.parseInt(driver.
                findElement(countInCartLocator).getText());
    }

    public int getItemsCount() {
        return driver.findElements(itemsLocator).size();
    }

    public void sortBy(String option) {
        Select select = new Select(driver.findElement(sortLocator));
        select.selectByVisibleText(option);
    }

    public boolean isDisplayedAddToCartButton(String itemName) {
        String productName = "add-to-cart-"
                + itemName.toLowerCase().replace(" ", "-");
        return driver.findElement(By.id(productName)).isDisplayed();
    }

    public boolean isDisplayedRemoveButton(String itemName) {
        String productName = "remove-"
                + itemName.toLowerCase().replace(" ", "-");
        return driver.findElement(By.id(productName)).isDisplayed();
    }


    public void clickCartIcon() {
        driver.findElement(cartIconLocator).click();
    }

}
