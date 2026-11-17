package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Constants.baseUrl);
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.validUsername, Constants.validPassword);
    }

    public void addTwoItemsToCart() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addToCart(Constants.backpack);
        pp.addToCart(Constants.onesie);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshot.toPath(),
                        Path.of("screenshots", result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

}
