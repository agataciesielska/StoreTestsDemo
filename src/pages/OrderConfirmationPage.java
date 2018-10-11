package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderConfirmationPage extends BasePage {
    //**********Constructor**********
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }
    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(xpath = "//strong[contains(.,'Your order on My Store is complete.')]")
    WebElement confirmationOfPlacedOrder;
    //**********Methods**********
    //**********Assertions**********
    public void confirmValidOrder(String expectedText) {
        Assert.assertTrue(readText(confirmationOfPlacedOrder).equalsIgnoreCase(expectedText));
    }
}
