package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by scrooge on 12.02.18.
 */
public class MessagePage {

    WebDriver driver;
    public static final By MESSAGE_TEXT = By.xpath("//span[@class='nim-dialog--inner-text']");

    public MessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setMessageText(){
        driver.findElement(MESSAGE_TEXT).getText();
    }
}
