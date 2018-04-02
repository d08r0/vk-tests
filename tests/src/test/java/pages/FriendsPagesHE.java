package pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.By;

public interface FriendsPagesHE extends WebPage {


    @FindBy("//input[@id='s_search']")
    HtmlElement SEARCH_FRIENDS();

    @FindBy("//a[@class='friends_field_act']")
    HtmlElement WRITE_MESSAGE_BUTTON();

    @FindBy("//div[@id='mail_box_editable']")
    HtmlElement ENTER_MESSAGE();

    @FindBy("//button[@class='flat_button fl_r mail_box_send_btn']")
    HtmlElement SEND_MESSAGE_BUTTON();

}
