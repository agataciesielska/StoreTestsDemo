package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePage {
    //**********Constructor**********
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(xpath = "//span[contains(.,'I confirm my order')]")
    WebElement confirmOrderButton;
    //**********Methods**********
    public OrderConfirmationPage clickIConfirmMyOrderButton() {
        click(confirmOrderButton);
        return new PageFactory().initElements(driver, OrderConfirmationPage.class);
    }
    //**********Assertions**********
}
