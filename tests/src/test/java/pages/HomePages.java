package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by scrooge on 11.02.18.
 */
public class HomePages {
    WebDriver driver;

    public static final By SEND_FRIENDS_BUTTON = By.xpath("//li[@id='l_fr']");
    public static final By MESSAGE_BUTTON = By.xpath("//li[@id='l_msg']");
    public static final By MENU_SETTING_BUTTON = By.xpath("//div[@class='left_settings_inner']");

    public static final By MUSIC_BUTTON = By.xpath("//li[@id='l_aud']");
    public static final By VIDEO_BUTTON = By.xpath("//li[@id='l_vid']");

    public static final By MUSIC_CHECK_BOX_ON = By.xpath("//a[@class='olist_item_wrap olist_item_menu olist_item_audio olist_item_wrap_on']");
    public static final By MUSIC_CHECK_BOX = By.xpath("//a[@class='olist_item_wrap olist_item_menu olist_item_audio']");


    public static final By VIDEO_CHECK_BOX_ON = By.xpath("//a[@class='olist_item_wrap olist_item_menu olist_item_video olist_item_wrap_on']");
    public static final By VIDEO_CHECK_BOX = By.xpath("//a[@class='olist_item_wrap olist_item_menu olist_item_video']");


    public static final By SAVE_BUTTON = By
            .xpath("//div[@class='popup_box_container']//div[@class='box_controls_wrap']//button[@class='flat_button']");



    public HomePages(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFriendsButon(){
        driver.findElement(SEND_FRIENDS_BUTTON).click();
    }

    public void clickMessageButon(){
        driver.findElement(MESSAGE_BUTTON).click();
    }


    public void clickMenuSettingButon(){
        driver.findElement(MENU_SETTING_BUTTON).click();
    }

    public WebElement MusicCheckBoxOn(){
       return driver.findElement(MUSIC_CHECK_BOX_ON);
    }

    public WebElement MusicCheckBoxOff(){
        return driver.findElement(MUSIC_CHECK_BOX);
    }

    public WebElement VideoCheckBoxOn(){
        return driver.findElement(VIDEO_CHECK_BOX_ON);
    }

    public WebElement VideoCheckBoxOff(){
        return driver.findElement(VIDEO_CHECK_BOX);
    }

    public WebElement SaveButton(){
        return driver.findElement(SAVE_BUTTON);
    }

    public WebElement MusicButton(){
        return driver.findElement(MUSIC_BUTTON);
    }
}
