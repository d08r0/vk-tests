package pages;

import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by scrooge on 11.02.18.
 */
public class LoginPages {

    WebDriver driver;
    public static final By ENTER_LOGIN = By.xpath("//input[@id='index_email']");
    public static final By ENTER_PASSWORD = By.xpath("//input[@id='index_pass']");
    public static final By SEND_LOGIN_BUTTON = By.xpath("//button[@id='index_login_button']");


    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }


    public void setLogin(String strUserName){
        driver.findElement(ENTER_LOGIN).sendKeys(strUserName);
    }

    public void setPassword(String strUserPassword){
        driver.findElement(ENTER_PASSWORD).sendKeys(strUserPassword);
    }

    public void clickLogin(){
        driver.findElement(SEND_LOGIN_BUTTON).click();
    }

}
