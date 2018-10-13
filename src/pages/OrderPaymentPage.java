package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public OrderSummaryPage clickPayByBankWireButton() {
        click(payByBankWireButton);
        return new PageFactory().initElements(driver, OrderSummaryPage.class);
    }

    public OrderSummaryPage clickPayByCheckButton() {
        click(payByCheckButton);
        return new PageFactory().initElements(driver, OrderSummaryPage.class);
    }
    //**********Assertions**********
}
