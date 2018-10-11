package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(css = ".logo")
    WebElement mainLogoBanner;

    //**********Methods**********
    public MainPage goToMainPage() {
        click(mainLogoBanner);
        return new PageFactory().initElements(driver, MainPage.class);
    }
    //**********Assertions**********
    public void verifyValidCreateAccount(String expectedText) {
        Assert.assertTrue(expectedText.equalsIgnoreCase(readText(myAccountHeadingConfirmation)));
    }
}
