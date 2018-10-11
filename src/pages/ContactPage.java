package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.regex.Pattern;

public class ContactPage extends BasePage {
    //**********Constructor**********
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    //**********Page Variables**********
    //**********Web Elements**********
    @FindBy(xpath = "//select[@id='id_contact']")
    WebElement selectSubject;

    @FindBy(css = ".validate")
    WebElement emailField;

    @FindBy(id = "id_order")
    WebElement orderIdField;

    @FindBy(id = "message")
    WebElement messageTextField;

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(css = ".alert-success")
    WebElement validMessageConfirmation;

    @FindBy(css = "ol li")
    WebElement errorMessageConfirmation;

    @FindBy(id = "fileUpload")
    WebElement chooseFileButton;

    @FindBy(className = "filename")
    WebElement fileUploadConfirmation;

    //**********Methods**********
    public void sendMessage(String value, String emailAddress, String orderId, String text) {
        selectFromDropdownListByValue(selectSubject, value);

        clearTextField(emailField);
        writeText(emailField, emailAddress);

        clearTextField(orderIdField);
        writeText(orderIdField, orderId);

        clearTextField(messageTextField);
        writeText(messageTextField, text);

        click(sendButton);
    }

    public void verifyValidMessageSend(String expectedText) {
        Assert.assertEquals(readText(validMessageConfirmation), expectedText);
    }

    public void verifyInvalidMessage(String expectedText) {
        Assert.assertEquals(readText(errorMessageConfirmation), expectedText);
    }

    public void fileUpload(String filePath) {
        uploadFile(chooseFileButton, filePath);
    }

    public void verifyUploadedFile(String fileName) {
        Pattern pattern = Pattern.compile("^" + fileName + "$");
        wait.until(ExpectedConditions.textMatches(By.className("filename"), pattern));
        Assert.assertTrue(readText(fileUploadConfirmation).matches(fileName));
    }
}