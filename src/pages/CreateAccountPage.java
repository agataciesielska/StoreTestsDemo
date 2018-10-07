package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CreateAccountPage extends BasePage {

    //**********Constructor**********
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(id = "id_gender1")
    WebElement mrTitleRadioButton;

    @FindBy(id = "id_gender2")
    WebElement mrsTitleRadioButton;

    @FindBy(id = "customer_firstname")
    WebElement personalInformationFirstNameField;

    @FindBy(id = "customer_lastname")
    WebElement personalInformationLastNameField;

    @FindBy(id = "email")
    WebElement personalInformationEmailField;

    @FindBy(id = "passwd")
    WebElement personalInformationPasswordField;

    @FindBy(id = "days")
    WebElement dateOfBirthDaySelect;

    @FindBy(id = "months")
    WebElement dateOfBirthMonthSelect;

    @FindBy(id = "years")
    WebElement dateOfBirthYearSelect;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOffersCheckbox;

    @FindBy(id = "firstname")
    WebElement addressFirstNameField;

    @FindBy(id = "lastname")
    WebElement addressLastNameField;

    @FindBy(id = "address1")
    WebElement addressAddressField;

    @FindBy(id = "city")
    WebElement addressCityField;

    @FindBy(id = "id_state")
    WebElement addressStateSelect;

    @FindBy(id = "postcode")
    WebElement addressPostcodeField;

    @FindBy(id = "id_country")
    WebElement addressCountrySelect;

    @FindBy(id = "phone_mobile")
    WebElement addressMobilePhoneField;

    @FindBy(id = "alias")
    WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(css = "ol li")
    WebElement errorMessage;

    //**********Methods**********
    public void createAccount(String personalInformationFirstName, String personalInformationLastName,
                              String personalInformationEmail, String password, String addressFirstName, String addressLastName,
                              String addressAddress, String addressCity, String state, String postcode, String country, String phoneNumber, String addressAlias) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

//        if (title.equalsIgnoreCase("mrs")) {
//            click(mrsTitleRadioButton);
//        }
//
//        if (title.equalsIgnoreCase("mr")) {
//            click(mrTitleRadioButton);
//        }

        clearTextField(personalInformationFirstNameField);
        writeText(personalInformationFirstNameField, personalInformationFirstName);

        clearTextField(personalInformationLastNameField);
        writeText(personalInformationLastNameField, personalInformationLastName);

        clearTextField(personalInformationEmailField);
        writeText(personalInformationEmailField, personalInformationEmail);

        clearTextField(personalInformationPasswordField);
        writeText(personalInformationPasswordField, password);

//        selectFromDropdownListByValue(dateOfBirthDaySelect, birthDay);
//        selectFromDropdownListByValue(dateOfBirthMonthSelect, birthMonth);
//        selectFromDropdownListByValue(dateOfBirthYearSelect, birthYear);

//        if (selectNewsletter) {
//            click(newsletterCheckbox);
//        }
//
//        if (selectSpecialOffers) {
//            click(specialOffersCheckbox);
//        }

        clearTextField(addressFirstNameField);
        writeText(addressFirstNameField, addressFirstName);

        clearTextField(addressLastNameField);
        writeText(addressLastNameField, addressLastName);

        clearTextField(addressAddressField);
        writeText(addressAddressField, addressAddress);

        clearTextField(addressCityField);
        writeText(addressCityField, addressCity);


        selectFromDropdownListByValue(addressStateSelect, state);

        clearTextField(addressPostcodeField);
        writeText(addressPostcodeField, postcode);

        selectFromDropdownListByValue(addressCountrySelect, country);

        clearTextField(addressMobilePhoneField);
        writeText(addressMobilePhoneField, phoneNumber);

        clearTextField(addressAliasField);
        writeText(addressAliasField, addressAlias);

        click(registerButton);
    }

    //**********Assertions**********
    public void verifyInvalidCreateAccount(String expectedText) {
        Assert.assertEquals(readText(errorMessage), expectedText);
    }
}
