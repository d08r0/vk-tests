package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by scrooge on 11.02.18.
 */
public class HomePages {
    WebDriver driver;

    public static final By SEND_FRIENDS_BUTTON = By.xpath("//li[@id='l_fr']");
    public static final By MESSAGE_BUTTON = By.xpath("//li[@id='l_msg']");

    public HomePages(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFriendsButon(){
        driver.findElement(SEND_FRIENDS_BUTTON).click();
    }

    public void clickMessageButon(){
        driver.findElement(MESSAGE_BUTTON).click();
    }

}
