package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{

    //**********Constructor**********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    public static String emailAddress;

    //**********Web Elements**********
    @FindBy(xpath = "//input[@id='email']")
    WebElement loginEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement loginPasswordField;

    @FindBy(id = "SubmitLogin")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement createAccountEmailField;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(css = "ol li")
    WebElement errorMessage;

    @FindBy(className = "info-account")
    WebElement validLoginMessage;

    @FindBy(xpath = "//div[@id='create_account_error']//li[.='Invalid email address.']")
    WebElement createAccountErrorMessage;

    //**********Methods**********
    public MyAccountPage loginToAccount (String uemail, String upassword) {
        clearTextField(loginEmailField);
        writeText(loginEmailField, uemail);
        clearTextField(loginPasswordField);
        writeText(loginPasswordField, upassword);
        click(loginButton);

        return new PageFactory().initElements(driver, MyAccountPage.class);
    }

    public void verifyValidLogin(String expectedText) {
        Assert.assertEquals(readText(validLoginMessage), expectedText);
    }

    public void verifyInvalidLogin(String expectedText) {
        Assert.assertEquals(readText(errorMessage), expectedText);
    }

    public void createAccountEmail(int length) {
        clearTextField(createAccountEmailField);
        emailAddress = generateRandomEmailAddress(length);
        writeText(createAccountEmailField, emailAddress);
        click(createAccountButton);
    }

    public void verifyInvalidCreateAccount(String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertEquals(readText(createAccountErrorMessage), expectedText);

    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
