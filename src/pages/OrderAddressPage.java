package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderAddressPage extends BasePage {
    //**********Constructor**********
    public OrderAddressPage(WebDriver driver) {
        super(driver);
    }
    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(xpath = "//button/span[contains(.,'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "textarea")
    WebElement commentField;
    //**********Methods**********
    public void clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
    }
    //**********Assertions**********
}
