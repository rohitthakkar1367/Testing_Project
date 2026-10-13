package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.openCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.startCheckout();
        checkout.fillDetails("Rohit", "Kumar", "380001");
        checkout.finishOrder();

        Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your order!");
    }
}