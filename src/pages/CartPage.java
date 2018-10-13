package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {
    //**********Constructor**********
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(css = ".icon-minus")
    WebElement reduceQuantityButton;

    @FindBy(css = ".icon-plus")
    WebElement increaseQuantityButton;

    @FindBy(xpath = "//input[@name='quantity_1_3_0_105498']")
    WebElement cartItemQuantity;

    @FindBy(css = ".icon-trash")
    WebElement removeItemButton;

    @FindBy(css = ".standard-checkout span")
    WebElement proceedToCheckoutButton;

    @FindBy(css = ".alert-warning")
    WebElement cartIsEmptyMessage;
    //**********Methods**********
    public OrderAddressPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new PageFactory().initElements(driver, OrderAddressPage.class);
    }

    public void clickRemoveItemButton() {
        click(removeItemButton);
    }

    public void clickReduceQuantityButton() {
        click(reduceQuantityButton);
    }

    public void clickIncreaseQuantityButton() {
        click(increaseQuantityButton);
    }

//    public String getQuantity() {
//        String quantity = cartItemQuantity.getAttribute("value");
//        return quantity;
//    }
    //**********Assertions**********
    public void removeFromCartConfirmation(String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(cartIsEmptyMessage));
        Assert.assertTrue(readText(cartIsEmptyMessage).equalsIgnoreCase(expectedText));
    }

    public void changeQuantityInCartValidation(String expectedQuantity) {
        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementValue(cartItemQuantity, expectedQuantity)));
    }
}
