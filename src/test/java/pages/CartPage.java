package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By titlePage = By.className("title");
    private By continueShoppingBtn = By.id("continue-shopping");
    private By checkoutBtn = By.className("checkout_button");
    private By itemName = By.className("inventory_item_name");
    private By cartBadgeCount = By.className("shopping_cart_badge");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.findElement(titlePage).getText();
    }

    public void removeItem(String itemName) {
        String product = "remove-" + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(product)).click();
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public int getCountItemsInCartPage() {
        return driver.findElements(itemName).size();
    }

    public List<String> getCartItems(){
        List<String> cartItems = new ArrayList<>();
        List<WebElement> items =driver.findElements(itemName);
        for (WebElement item : items) {
            cartItems.add(item.getText());
        }
        return cartItems;
    }

}