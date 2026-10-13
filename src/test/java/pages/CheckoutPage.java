package pages;

import org.openqa.selenium.*;

public class CheckoutPage extends BasePage {
    private By checkoutBtn  = By.id("checkout");
    private By firstName    = By.id("first-name");
    private By lastName     = By.id("last-name");
    private By postalCode   = By.id("postal-code");
    private By continueBtn  = By.id("continue");
    private By finishBtn    = By.id("finish");
    private By successText  = By.className("complete-header");

    public CheckoutPage(WebDriver driver) { super(driver); }

    public void startCheckout() { click(checkoutBtn); }

    public void fillDetails(String first, String last, String zip) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, zip);
        click(continueBtn);
    }

    public void finishOrder() { click(finishBtn); }

    public String getSuccessMessage() { return getText(successText); }
}