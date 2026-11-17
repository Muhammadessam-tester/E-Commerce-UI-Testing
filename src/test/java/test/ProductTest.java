package test;

import base.BaseTest;
import base.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductsPageTitle() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        Assert.assertEquals(pp.getPageTitle(), "Products",
                "Products page title is not correct");
    }

    @Test
    public void verifyLogout() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.logout();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.baseUrl,
                "Logout is not Successfully");
    }

    @Test
    public void verifySessionAfterLogout() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.logout();
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.baseUrl,
                "Product page is accessible after logout");
    }

    @Test
    public void verifyAddToCart() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addToCart(Constants.backpack);
        pp.goToCartPage();
        CartPage cp = new CartPage(driver);
        Assert.assertEquals(cp.getCountItemsInCartPage(), 1,
                "Item is not added to the cart");
        Assert.assertEquals(pp.getNumOfProductsAddInCartIcon(), 1,
                "Item is not added to the cart");
        Assert.assertEquals(cp.getTitlePage(), "Your Cart",
                "Cart page title is not correct");
    }

    @Test
    public void verifyAddMultipleToCart() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addToCart(Constants.backpack);
        pp.addToCart(Constants.onesie);
        pp.goToCartPage();
        Assert.assertEquals(pp.getNumOfProductsAddInCartIcon(), 2,
                "Item is not added to the cart");
        Assert.assertTrue(pp.isDisplayedRemoveButton(Constants.backpack),
                "Remove button is not displayed for sauce labs backpack");
        Assert.assertTrue(pp.isDisplayedRemoveButton(Constants.onesie),
                "Remove button is not displayed for sauce labs onesie");
    }

    @Test
    public void verifyRemoveFromCart() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addToCart(Constants.backpack);
        pp.addToCart(Constants.onesie);
        pp.removeFromTheCart(Constants.backpack);
        Assert.assertEquals(pp.getNumOfProductsAddInCartIcon(), 1,
                "Item is not removed from the cart");
        Assert.assertTrue(pp.isDisplayedAddToCartButton(Constants.backpack),
                "Add to cart button is not clickable for sauce labs backpack");
    }
}