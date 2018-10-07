package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
    //**********Constructor**********
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(css = ".page-heading")
    WebElement myAccountHeadingConfirmation;
    //**********Methods**********
    //**********Assertions**********
    public void verifyValidCreateAccount(String expectedText) {
        Assert.assertTrue(expectedText.equalsIgnoreCase(readText(myAccountHeadingConfirmation)));
    }
}
