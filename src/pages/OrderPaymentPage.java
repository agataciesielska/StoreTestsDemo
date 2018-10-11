package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPaymentPage extends BasePage {
    //**********Constructor**********
    public OrderPaymentPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(className = "bankwire")
    WebElement payByBankWireButton;

    @FindBy(className = "cheque")
    WebElement payByCheckButton;
    //**********Methods**********
    public void clickPayByBankWireButton() {
        click(payByBankWireButton);
    }

    public void clickPayByCheckButton() {
        click(payByCheckButton);
    }
    //**********Assertions**********
}
