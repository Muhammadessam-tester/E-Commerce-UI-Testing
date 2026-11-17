package test;

import base.BaseTest;
import base.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.validUsername, Constants.validPassword);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login failed, user not redirected to inventory page.");
    }

    @Test
    public void loginUsingEnter() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUsingEnterKey(Constants.validUsername, Constants.validPassword);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login failed, user not redirected to inventory page.");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"invalid_user", Constants.validPassword},
                {Constants.validUsername, "wrong_password"},
                {"invalid_user", "wrong_password"},
                {"", ""},
                {Constants.validUsername, ""},
                {"", Constants.validPassword}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message not displayed for invalid credentials.");
    }
    @Test
    public void usernameCaseSensitivity(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("STANDARD_USER", Constants.validPassword);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login failed, user not redirected to inventory page.");
    }
    @Test
    public void passwordCaseSensitivity(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.validUsername, "SECRET_SAUCE");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message not displayed for invalid password case.");
    }

}
