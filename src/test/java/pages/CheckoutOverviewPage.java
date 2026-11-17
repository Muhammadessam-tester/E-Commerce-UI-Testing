package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private WebDriver driver;

    private By titlePage = By.className("title");
    private By cancelBtn = By.cssSelector("#cancel");
    private By finishBtn = By.cssSelector("#finish");
    private By itemName = By.className("inventory_item_name");
    private By priceItemsLocator = By.cssSelector(".inventory_item_price");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.findElement(titlePage).getText();
    }

    public void clickCancel() {
        driver.findElement(cancelBtn).click();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public int getCountItemsInCheckoutPage() {
        return driver.findElements(itemName).size();
    }
}
