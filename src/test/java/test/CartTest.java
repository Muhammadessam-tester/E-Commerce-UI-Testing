package test;

import base.BaseTest;
import base.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import java.util.Arrays;
import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartPageTitle() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        String actualTitle = cp.getTitlePage();
        String expectedTitle = "Your Cart";
        Assert.assertEquals(actualTitle, expectedTitle,
                "Cart page title is not as expected");
    }

    @Test
    public void verifyTheSameSelectedItemsDisplayed() {

        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        List<String> expectedItems = Arrays.asList(Constants.backpack, Constants.onesie);
        List<String> actualItems = cp.getCartItems();
        Assert.assertEquals(actualItems, expectedItems,
                "The items in the cart are not as expected");
    }

    @Test
    public void verifyRemoveItemFromCart() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.removeItem(Constants.backpack);
        List<String> expectedItems = Arrays.asList(Constants.onesie);
        List<String> actualItems = cp.getCartItems();
        Assert.assertEquals(actualItems, expectedItems,
                "The item was not removed from the cart as expected");
    }

    @Test
    public void verifyContinueShoppingButton() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.invUrl,
                "Continue Shopping button did not navigate to the products page");
    }

    @Test
    public void verifyCheckoutButton() {
        addTwoItemsToCart();
        ProductsPage pp = new ProductsPage(driver);
        pp.clickCartIcon();
        CartPage cp = new CartPage(driver);
        cp.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.checkoutInfoUrl,
                "Checkout button did not navigate to the checkout page");
    }
}
