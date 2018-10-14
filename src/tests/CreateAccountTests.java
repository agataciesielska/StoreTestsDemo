package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;

public class CreateAccountTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeCreateNewAccountMethods() {
        // When
        page.GetInstance(MainPage.class).goToLoginPage();
    }

    @Test
    public void invalidCreateAccount_InvalidEmailAddress() {
        // Given
        int emailLength = 0;

        // When
        page.GetInstance(LoginPage.class).createAccountEmail(emailLength);

        // Then
        page.GetInstance(LoginPage.class).verifyInvalidCreateAccount("Invalid email address.");
    }

    @Test(groups = {"smoke tests"})
    public void validCreateAccount() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(MyAccountPage.class).verifyValidCreateAccount("My account");

    }

    @Test
    public void invalidCreateAccount_EmptyFirstNameInPersonalInformation() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setPersonalInformationFirstName("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("firstname is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyLastNameInPersonalInformation() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setPersonalInformationLastName("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("lastname is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyEmailAddress() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setPersonalInformationEmail("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("email is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyPassword() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setPassword("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("passwd is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyFirstNameInAddress() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setAddressFirstName("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("firstname is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyLastNameInAddress() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setAddressLastName("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("lastname is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyAddress() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setAddressAddress("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("address1 is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyCity() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setAddressCity("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("city is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyState() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setState("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("This country requires you to choose a State.");
    }

    @Test
    public void invalidCreateAccount_EmptyPostcode() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setPostcode("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
    }

    @Test
    public void invalidCreateAccount_EmptyCountry() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setCountry("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("id_country is required.");
    }

    @Test
    public void invalidCreateAccount_EmptyPhoneNumber() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setPhoneNumber("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("You must register at least one phone number.");
    }

    @Test
    public void invalidCreateAccount_EmptyAlias() {
        // Given
        page.GetInstance(LoginPage.class).createAccountEmail(7);
        CreateAccountPage.createAccountData.setAddressAlias("");

        // When
        page.GetInstance(CreateAccountPage.class).createAccount();

        // Then
        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("alias is required.");
    }


//    Working test
//    @Test(groups = {"smoke tests"})
//    public void validCreateAccount() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(MyAccountPage.class).verifyValidCreateAccount("My account");
//
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyFirstNameInPersonalInformation() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("firstname is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyLastNameInPersonalInformation() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("lastname is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyEmailAddress() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", "", "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("email is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyPassword() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("passwd is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyFirstNameInAddress() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("firstname is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyLastNameInAddress() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("lastname is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyAddress() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","",
//                "Testcity", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("address1 is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyCity() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "", "5", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("city is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyState() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "", "12345", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("This country requires you to choose a State.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyPostcode() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "", "21", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyCountry() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "", "0987654321", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("id_country is required.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyPhoneNumber() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "", "Testalias");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("You must register at least one phone number.");
//    }
//
//    @Test
//    public void invalidCreateAccount_EmptyAlias() {
//        page.GetInstance(LoginPage.class).createAccountEmail(7);
//        String email = page.GetInstance(LoginPage.class).getEmailAddress();
//        page.GetInstance(CreateAccountPage.class).createAccount("Testfirstname", "Testlastname", email, "Testpassword",
//                "Testfirstname", "Testlastname","Teststreet 123",
//                "Testcity", "5", "12345", "21", "0987654321", "");
//
//        // Then
//        page.GetInstance(CreateAccountPage.class).verifyInvalidCreateAccount("alias is required.");
//    }


}
