package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTestMethods() {
        page.GetInstance(MainPage.class).goToLoginPage();
    }

    @Test(groups = {"smoke tests"})
    public void validLoginTest() {
        page.GetInstance(LoginPage.class).loginToAccount("testmail@mymail.com", "12345qw");

        //**********Assertions**********
        page.GetInstance(LoginPage.class).verifyValidLogin("Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void invalidLoginTest_EmptyEmail() {
        page.GetInstance(LoginPage.class).loginToAccount("", "password");

        //**********Assertions**********
        page.GetInstance(LoginPage.class).verifyInvalidLogin("An email address required.");
    }

    @Test
    public void invalidLoginTest_EmptyPassword() {
        page.GetInstance(LoginPage.class).loginToAccount("testmail@mymail.com", "");

        //**********Assertions**********
        page.GetInstance(LoginPage.class).verifyInvalidLogin("Password is required.");
    }
}
