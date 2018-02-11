package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by scrooge on 11.02.18.
 */
public class FriendsPages {

    WebDriver driver;
    public static final By SEARCH_FRIENDS = By.xpath("//input[@id='s_search']");
    public static final By WRITE_MESSAGE_BUTTON = By.xpath("//a[@class='friends_field_act']");
    public static final By ENTER_MESSAGE = By.xpath("//div[@id='mail_box_editable']");
    public static final By SEND_MESSAGE_BUTTON = By.xpath("//button[@class='flat_button fl_r mail_box_send_btn']");

    public FriendsPages(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchFriends(String strFriendsName){
        driver.findElement(SEARCH_FRIENDS).sendKeys(strFriendsName);
    }

    public void clickWriteMessageButton(){
        driver.findElement(WRITE_MESSAGE_BUTTON).click();
    }

    public void setMessage(String strMessage){
        driver.findElement(ENTER_MESSAGE).sendKeys(strMessage);
    }

    public void clickSendMessageButton(){
        driver.findElement(SEND_MESSAGE_BUTTON).click();
    }
}
