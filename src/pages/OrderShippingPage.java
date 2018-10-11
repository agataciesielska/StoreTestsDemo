package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderShippingPage extends BasePage {
    //**********Constructor**********
    public OrderShippingPage(WebDriver driver) {
        super(driver);
    }
    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(id = "cgv")
    WebElement termsAgreeCheckbox;

    @FindBy(xpath = "//button/span[contains(.,'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(css = ".fancybox-error")
    WebElement acceptTermErrorMessage;

    //**********Methods**********
    public void acceptTermsAndProceedToCheckout() {
        click(termsAgreeCheckbox);
        click(proceedToCheckoutButton);
    }

    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }


    //**********Assertions**********
    public void verifyInvalidPurchase_TermsNotAccepted() {
        Assert.assertNotNull(wait.until(ExpectedConditions.visibilityOf(acceptTermErrorMessage)));
    }
}
