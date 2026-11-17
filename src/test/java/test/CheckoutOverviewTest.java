package test;

import base.BaseTest;
import base.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOverviewTest extends BaseTest {


    @Test
    public void verifyCheckoutOverviewTitle() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "essam", "12345");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        String expectedTitle = "Checkout: Overview";
        String actualTitle = checkoutOverviewPage.getTitlePage();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "The title of the checkout overview page is incorrect.");
    }

    @Test
    public void verifyCancelButtonAtCheckoutOverview() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "essam", "12345");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickCancel();
        String expectedUrl = Constants.cartUrl;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "The URL is incorrect after clicking the cancel button.");
    }

    @Test
    public void verifyFinishButton() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "essam", "12345");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinish();
        CompletePage completePage = new CompletePage(driver);
        String expectedTitle = "checkout: complete!";
        String actualTitle = completePage.getTitlePage();
        Assert.assertEquals(actualTitle, expectedTitle,
                "The title of the complete page is incorrect.");
        Assert.assertEquals(completePage.getCompleteMessage(), "Thank you for your order!",
                "The complete message is incorrect.");
    }

    @Test
    public void verifyBackHomeButton() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "essam", "12345");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinish();
        CompletePage completePage = new CompletePage(driver);
        completePage.clickBackToProductsBtn();
        String expectedUrl = Constants.invUrl;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "The URL is incorrect after clicking the back to products button.");
    }
}