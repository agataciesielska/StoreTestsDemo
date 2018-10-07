package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.MainPage;

public class ContactTests extends BaseTest {

    @BeforeMethod
    public void beforeContactTestMethods() {
        page.GetInstance(MainPage.class).goToContactPage();
    }

    @Test(groups = {"smoke tests"})
    public void sendValidMessage() {
        page.GetInstance(ContactPage.class).sendMessage("1", "testemail@myemail.com", "123456", "Test message");

        //**********Assertions**********
        page.GetInstance(ContactPage.class).verifyValidMessageSend("Your message has been successfully sent to our team.");
    }

    @Test
    public void sendInvalidMessage_EmptySubject() {
        page.GetInstance(ContactPage.class).sendMessage("0", "testemail@myemail.com", "123456", "Test message");

        //**********Assertions**********
        page.GetInstance(ContactPage.class).verifyInvalidMessage("Please select a subject from the list provided.");
    }

    @Test
    public void sendInvalidMessage_EmptyEmail() {
        page.GetInstance(ContactPage.class).sendMessage("2", "", "123456", "Test message");

        //**********Assertions**********
        page.GetInstance(ContactPage.class).verifyInvalidMessage("Invalid email address.");
    }

    @Test
    public void sendInvalidMessage_EmptyMessage() {
        page.GetInstance(ContactPage.class).sendMessage("1", "testemail@myemail.com", "123456", "");

        //**********Assertions**********
        page.GetInstance(ContactPage.class).verifyInvalidMessage("The message cannot be blank.");
    }

    @Test
    public void validFileUpload() throws InterruptedException {
        page.GetInstance(ContactPage.class).fileUpload("C:\\testFile.txt");

        //**********Assertions**********
        page.GetInstance(ContactPage.class).verifyUploadedFile("testFile.txt");
    }
}
