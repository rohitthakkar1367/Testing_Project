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

    public void startCheckout() {
        WebElement button = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(checkoutBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("checkout-step-one"));
    }

    public void fillDetails(String first, String last, String zip) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, zip);
        click(continueBtn);
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void finishOrder() { click(finishBtn); }

    public String getSuccessMessage() { return getText(successText); }
}