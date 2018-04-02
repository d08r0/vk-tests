package pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by scrooge on 11.02.18.
 */

    public interface LoginPagesHE extends WebPage {

        @FindBy("//input[@id='index_email']")
        HtmlElement ENTER_LOGIN();

        @FindBy("//input[@id='index_pass']")
        HtmlElement ENTER_PASSWORD();

        @FindBy("//button[@id='index_login_button']")
        HtmlElement SEND_LOGIN_BUTTON();

    }
