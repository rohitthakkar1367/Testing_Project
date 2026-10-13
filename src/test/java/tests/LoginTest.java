package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        Assert.assertEquals(new ProductsPage(driver).getTitle(), "Products");
    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() {
        return new Object[][] {
            {"wrong_user", "secret_sauce", "Username and password do not match"},
            {"standard_user", "wrong_pass", "Username and password do not match"},
            {"", "", "Username is required"}
        };
    }

    @Test(dataProvider = "invalidData")
    public void invalidLogin(String user, String pass, String expectedError) {
        LoginPage login = new LoginPage(driver);
        login.login(user, pass);
        Assert.assertTrue(login.getErrorMessage().contains(expectedError));
    }
}