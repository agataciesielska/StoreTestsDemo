package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.MainPage;

public class ContactTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeContactTestMethods() {
        // When
        page.GetInstance(MainPage.class).goToContactPage();
    }

    @Test(groups = {"smoke tests"})
    public void sendValidMessage() {
        // Given
        String subjectValue = "1";
        String emailAddress = "testemail@myemail.com";
        String orderId = "123456";
        String message = "Test message";

        // When
        page.GetInstance(ContactPage.class).sendMessage(subjectValue, emailAddress, orderId, message);

        // Then
        page.GetInstance(ContactPage.class).verifyValidMessageSend("Your message has been successfully sent to our team.");
    }

    @Test
    public void sendInvalidMessage_EmptySubject() {
        // Given
        String subjectValue = "0";
        String emailAddress = "testemail@myemail.com";
        String orderId = "123456";
        String message = "Test message";

        // When
        page.GetInstance(ContactPage.class).sendMessage(subjectValue, emailAddress, orderId, message);

        // Then
        page.GetInstance(ContactPage.class).verifyInvalidMessage("Please select a subject from the list provided.");
    }

    @Test
    public void sendInvalidMessage_EmptyEmail() {
        // Given
        String subjectValue = "2";
        String emailAddress = "";
        String orderId = "123456";
        String message = "Test message";

        // When
        page.GetInstance(ContactPage.class).sendMessage(subjectValue, emailAddress, orderId, message);

        // Then
        page.GetInstance(ContactPage.class).verifyInvalidMessage("Invalid email address.");
    }

    @Test
    public void sendInvalidMessage_EmptyMessage() {
        // Given
        String subjectValue = "1";
        String emailAddress = "testemail@myemail.com";
        String orderId = "123456";
        String message = "";

        // When
        page.GetInstance(ContactPage.class).sendMessage(subjectValue, emailAddress, orderId, message);

        // Then
        page.GetInstance(ContactPage.class).verifyInvalidMessage("The message cannot be blank.");
    }

    @Test
    public void validFileUpload() {
        String filePath = "C:\\testFile.txt";
        String fileName = "testFile.txt";

        page.GetInstance(ContactPage.class).fileUpload(filePath);

        // Then
        page.GetInstance(ContactPage.class).verifyUploadedFile(fileName);
    }
}
