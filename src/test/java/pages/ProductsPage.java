package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private By pageTitle      = By.className("title");
    private By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon       = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) { super(driver); }

    public String getTitle() { return getText(pageTitle); }

    public void addBackpackToCart() { click(addBackpackBtn); }

    public void openCart() {
        click(cartIcon);
        wait.until(ExpectedConditions.urlContains("cart.html"));
    }
}