package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.CreateAccountData;

public class CreateAccountPage extends BasePage {

    //**********Constructor**********
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    public static CreateAccountData createAccountData = new CreateAccountData(
            "Testfirstname",
            "Testlastname",
            LoginPage.emailAddress,
            "Testpassword",
            "Testfirstname",
            "Testlastname",
            "Teststreet 123",
            "Testcity",
            "5",
            "12345",
            "21",
            "0987654321",
            "Testalias");

    //**********Web Elements**********
    @FindBy(id = "customer_firstname")
    WebElement personalInformationFirstNameField;

    @FindBy(id = "customer_lastname")
    WebElement personalInformationLastNameField;

    @FindBy(id = "email")
    WebElement personalInformationEmailField;

    @FindBy(id = "passwd")
    WebElement personalInformationPasswordField;

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
    // Working method:
//    public void createAccount(String personalInformationFirstName, String personalInformationLastName,
//                              String personalInformationEmail, String password, String addressFirstName, String addressLastName,
//                              String addressAddress, String addressCity, String state, String postcode, String country, String phoneNumber, String addressAlias) {
//
//        wait.until(ExpectedConditions.visibilityOf(personalInformationFirstNameField));
//
//        clearTextField(personalInformationFirstNameField);
//        writeText(personalInformationFirstNameField, personalInformationFirstName);
//
//        clearTextField(personalInformationLastNameField);
//        writeText(personalInformationLastNameField, personalInformationLastName);
//
//        clearTextField(personalInformationEmailField);
//        writeText(personalInformationEmailField, personalInformationEmail);
//
//        clearTextField(personalInformationPasswordField);
//        writeText(personalInformationPasswordField, password);
//
//        clearTextField(addressFirstNameField);
//        writeText(addressFirstNameField, addressFirstName);
//
//        clearTextField(addressLastNameField);
//        writeText(addressLastNameField, addressLastName);
//
//        clearTextField(addressAddressField);
//        writeText(addressAddressField, addressAddress);
//
//        clearTextField(addressCityField);
//        writeText(addressCityField, addressCity);
//
//        selectFromDropdownListByValue(addressStateSelect, state);
//
//        clearTextField(addressPostcodeField);
//        writeText(addressPostcodeField, postcode);
//
//        selectFromDropdownListByValue(addressCountrySelect, country);
//
//        clearTextField(addressMobilePhoneField);
//        writeText(addressMobilePhoneField, phoneNumber);
//
//        clearTextField(addressAliasField);
//        writeText(addressAliasField, addressAlias);
//
//        click(registerButton);
//    }

    public void createAccount() {

        wait.until(ExpectedConditions.visibilityOf(personalInformationFirstNameField));

        clearTextField(personalInformationFirstNameField);
        writeText(personalInformationFirstNameField, createAccountData.getPersonalInformationFirstName());

        clearTextField(personalInformationLastNameField);
        writeText(personalInformationLastNameField, createAccountData.getPersonalInformationLastName());

        clearTextField(personalInformationEmailField);
        writeText(personalInformationEmailField, createAccountData.getPersonalInformationEmail());

        clearTextField(personalInformationPasswordField);
        writeText(personalInformationPasswordField, createAccountData.getPassword());

        clearTextField(addressFirstNameField);
        writeText(addressFirstNameField, createAccountData.getAddressFirstName());

        clearTextField(addressLastNameField);
        writeText(addressLastNameField, createAccountData.getAddressLastName());

        clearTextField(addressAddressField);
        writeText(addressAddressField, createAccountData.getAddressAddress());

        clearTextField(addressCityField);
        writeText(addressCityField, createAccountData.getAddressCity());

        selectFromDropdownListByValue(addressStateSelect, createAccountData.getState());

        clearTextField(addressPostcodeField);
        writeText(addressPostcodeField, createAccountData.getPostcode());

        selectFromDropdownListByValue(addressCountrySelect, createAccountData.getCountry());

        clearTextField(addressMobilePhoneField);
        writeText(addressMobilePhoneField, createAccountData.getPhoneNumber());

        clearTextField(addressAliasField);
        writeText(addressAliasField, createAccountData.getAddressAlias());

        click(registerButton);
    }

//    public static CreateAccountData createAccountData() {
//        return new CreateAccountData.Builder()
//                .personalInformationFirstName("Testfirstname")
//                .personalInformationLastName("Testlastname")
//                .personalInformationEmail(LoginPage.emailAddress)
//                .password("Testpassword")
//                .addressFirstName("Testfirstname")
//                .addressLastName("Testlastname")
//                .addressAddress("Teststreet 123")
//                .addressCity("Testcity")
//                .state("5")
//                .postcode("12345")
//                .country("21")
//                .phoneNumber("0987654321")
//                .addressAlias("Testalias")
//                .build();
//    }

    //**********Assertions**********
    public void verifyInvalidCreateAccount(String expectedText) {
        Assert.assertEquals(readText(errorMessage), expectedText);
    }
}
