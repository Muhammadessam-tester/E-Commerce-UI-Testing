package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
    private WebDriver driver;

    private By titlePage = By.className("title");
    private By completeMessage = By.className("complete-header");
    private By backToProductsBtn = By.id("back-to-products");


    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.findElement(titlePage).getText().toLowerCase();
    }

    public String getCompleteMessage() {
        return driver.findElement(completeMessage).getText();
    }

    public void clickBackToProductsBtn() {
        driver.findElement(backToProductsBtn).click();
    }

}
