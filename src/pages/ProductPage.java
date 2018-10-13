package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    //**********Constructor**********
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(id = "quantity_wanted")
    WebElement quantityField;

    @FindBy(id = "group_1")
    WebElement selectSize;

    @FindBy(css = "#add_to_cart span")
    WebElement addToCartButton;

    @FindBy(css = ".button-medium span")
    WebElement proceedToCheckoutPopupButton;
    //**********Methods**********
    public CartPage addToCart(String quantity, String sizeValue) {
        clearTextField(quantityField);
        writeText(quantityField, quantity);

        selectFromDropdownListByValue(selectSize, sizeValue);

        click(addToCartButton);

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutPopupButton));
        click(proceedToCheckoutPopupButton);

        return new PageFactory().initElements(driver, CartPage.class);
    }
    //**********Assertions**********
}
