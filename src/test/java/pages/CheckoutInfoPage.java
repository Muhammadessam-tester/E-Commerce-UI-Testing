package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
    private WebDriver driver;

    private By titlePage = By.className("title");
    private By firstNameLocator = By.id("first-name");
    private By lastNameLocator = By.id("last-name");
    private By postalCodeLocator = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By cancelBtn = By.cssSelector("#cancel");
    private By errorMessageLocator = By.cssSelector(".error-message-container");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.findElement(titlePage).getText();
    }

    public void enterYourInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        driver.findElement(postalCodeLocator).sendKeys(postalCode);
        driver.findElement(continueBtn).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickCancel() {
        driver.findElement(cancelBtn).click();
    }

    public boolean errorMessageIsDisplayed() {
        try {
            return driver.findElement(errorMessageLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
