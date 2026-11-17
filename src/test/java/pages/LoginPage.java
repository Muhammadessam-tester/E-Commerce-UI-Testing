package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;

    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By errorMessageLocator = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButtonLocator).click();
    }
    public void login(String username , String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public String errorMessageText(){
       return driver.findElement(errorMessageLocator).getText();
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(errorMessageLocator).isDisplayed();
    }
    public void loginUsingEnterKey(String username, String password){
        enterUsername(username);
        enterPassword(password);
        new Actions(driver).sendKeys(driver.findElement(passwordLocator), Keys.ENTER).perform();
    }
}
