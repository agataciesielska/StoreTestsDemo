package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "//ul[@id='homefeatured']//li//div[@class='product-container']//div[@class='product-image-container']" +
            "//a[@title='Faded Short Sleeve T-shirts']//img[@alt='Faded Short Sleeve T-shirts']")
    WebElement productPhoto;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]/div[@class='product-container']//a[@title='View']/span[.='More']")
    WebElement moreAboutProductButton;

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

    public ProductPage goToProductPage() {
        moveCursorToElement(productPhoto);
        wait.until(ExpectedConditions.visibilityOf(moreAboutProductButton));
        click(moreAboutProductButton);
        return new PageFactory().initElements(driver, ProductPage.class);
    }
}
