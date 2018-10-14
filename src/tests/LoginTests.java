package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTestMethods() {
        // When
        page.GetInstance(MainPage.class).goToLoginPage();
    }

    @Test(groups = {"smoke tests"})
    public void validLoginTest() {
        // Given
        String loginEmail = "testmail@mymail.com";
        String loginPassword = "12345qw";

        // When
        page.GetInstance(LoginPage.class).loginToAccount(loginEmail, loginPassword);

        // Then
        page.GetInstance(LoginPage.class).verifyValidLogin("Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void invalidLoginTest_EmptyEmail() {
        // Given
        String loginEmail = "";
        String loginPassword = "12345qw";

        // When
        page.GetInstance(LoginPage.class).loginToAccount(loginEmail, loginPassword);

        // Then
        page.GetInstance(LoginPage.class).verifyInvalidLogin("An email address required.");
    }

    @Test
    public void invalidLoginTest_EmptyPassword() {
        // Given
        String loginEmail = "testmail@mymail.com";
        String loginPassword = "";

        // When
        page.GetInstance(LoginPage.class).loginToAccount(loginEmail, loginPassword);

        // Then
        page.GetInstance(LoginPage.class).verifyInvalidLogin("Password is required.");
    }
}
