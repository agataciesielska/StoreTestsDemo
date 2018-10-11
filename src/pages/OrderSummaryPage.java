package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public void clickIConfirmMyOrderButton() {
        click(confirmOrderButton);
    }
    //**********Assertions**********
}
