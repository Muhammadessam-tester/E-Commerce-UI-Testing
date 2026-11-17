package test;

import base.BaseTest;
import base.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.ProductsPage;

public class CheckoutInfoTest extends BaseTest {

    @Test
    public void verifyCheckoutInfoPageTitle() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        String expectedTitle = "Checkout: Your Information";
        String actualTitle = checkoutInfoPage.getTitlePage();
        Assert.assertEquals(actualTitle, expectedTitle,
                "The title of the checkout info page is incorrect.");
    }

    @Test
    public void verifyCancelButtonAtCheckoutInfo() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.clickCancel();
        String expectedUrl = Constants.cartUrl;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "The URL is incorrect after clicking the cancel button.");
    }

    @Test
    public void verifyContinueButtonWithValidInput() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "essam", "12345");
        String expectedUrl = Constants.checkoutOverviewUrl;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "The URL is incorrect after clicking the continue button with valid input.");
    }

    @Test
    public void verifyContinueButtonWithoutInput() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("", "", "");
        Assert.assertTrue(checkoutInfoPage.errorMessageIsDisplayed(),
                "Error message is not displayed when trying to continue without input.");
    }

    @Test
    public void verifySubmitwithEmptyFirstName() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("", "essam", "12345");
        Assert.assertTrue(checkoutInfoPage.errorMessageIsDisplayed(),
                "Error message is not displayed when trying to continue with empty first name.");
    }

    @Test
    public void verifySubmitwithEmptyLastName() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "", "12345");
        Assert.assertTrue(checkoutInfoPage.errorMessageIsDisplayed(),
                "Error message is not displayed when trying to continue with empty last name.");
    }

    @Test
    public void verifySubmitWithEmptyPostalCode() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("muhammad", "essam", "");
        Assert.assertTrue(checkoutInfoPage.errorMessageIsDisplayed(),
                "Error message is not displayed when trying to continue with empty postal code.");
    }

    @Test
    public void verifyEnterSpacesOnlyInFields() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.enterYourInfo("   ", "   ", "   ");
        Assert.assertTrue(checkoutInfoPage.errorMessageIsDisplayed(),
                "Error message is not displayed when trying to continue with spaces only in fields.");
    }
}