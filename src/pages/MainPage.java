package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    //**********Constructor**********
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    String baseURL = "http://automationpractice.com/index.php";

    //**********Web Elements**********
    @FindBy(id = "contact-link")
    public WebElement contactButton;

    @FindBy(className = "login")
    public WebElement loginButton;

    //**********Methods**********
    public ContactPage goToContactPage() {
        click(contactButton);
        return new PageFactory().initElements(driver, ContactPage.class);
    }

    public void goToMainPage() {
        driver.get(baseURL);
    }

    public LoginPage goToLoginPage() {
        click(loginButton);
        return new PageFactory().initElements(driver, LoginPage.class);
    }
}
