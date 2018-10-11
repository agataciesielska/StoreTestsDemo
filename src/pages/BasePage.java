package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(this.driver, 20);


    //Click Method
    public <T> void click(T elementLocation) {
        if (elementLocation.getClass().getName().contains("By")) {
            driver.findElement((By) elementLocation).click();
        } else {
            ((WebElement) elementLocation).click();
        }
    }

    //Write Text
    public <T> void writeText(T elementLocation, String text) {
        if (elementLocation.getClass().getName().contains("By")) {
            driver.findElement((By) elementLocation).sendKeys(text);
        } else {
            ((WebElement) elementLocation).sendKeys(text);
        }
    }

    //Read Text
    public <T> String readText(T elementLocation) {
        if (elementLocation.getClass().getName().contains("By")) {
            return driver.findElement((By) elementLocation).getText();
        } else {
            return ((WebElement) elementLocation).getText();
        }
    }

    //Clear Text Field
    public <T> void clearTextField(T elementLocation) {
        if (elementLocation.getClass().getName().contains("By")) {
            driver.findElement((By) elementLocation).clear();
        } else {
            ((WebElement) elementLocation).clear();
        }
    }

    //Generate Random Email Address
    public static String generateRandomEmailAddress(int emailLength) {
        String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomEmail = new StringBuilder();
        Random rnd = new Random();
        while (randomEmail.length() < emailLength) {
            int index = (int) (rnd.nextFloat() * allChars.length());
            randomEmail.append(allChars.charAt(index));
        }
        randomEmail.append("@myemail.com");
        String emailAddress = randomEmail.toString();
        return emailAddress;
    }

    //Select From Dropdown List By Value
    public <T> void selectFromDropdownListByValue(T elementLocation, String value) {
        if (elementLocation.getClass().getName().contains("By")) {
            Select select = new Select(driver.findElement((By) elementLocation));
            select.selectByValue(value);
        } else {
            Select select = new Select((WebElement) elementLocation);
            select.selectByValue(value);
        }
    }

    //Upload File
    public <T> void uploadFile(T elementLocation, String filePath) {
        if (elementLocation.getClass().getName().contains("By")) {
            driver.findElement((By) elementLocation).click();
        } else {
            ((WebElement) elementLocation).click();
        }
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public <T> void moveCursorToElement(T elementLocation) {
        Actions action = new Actions(this.driver);
        action.moveToElement((WebElement) elementLocation).perform();
    }
}
