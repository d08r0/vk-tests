package pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.By;

public interface HomePagesHE extends WebPage {



    @FindBy("//li[@id='l_fr']")
    HtmlElement SEND_FRIENDS_BUTTON();

    @FindBy("//li[@id='l_msg']")
    HtmlElement MESSAGE_BUTTON();

    @FindBy("//div[@class='left_settings_inner']")
    HtmlElement MENU_SETTING_BUTTON();

    @FindBy("//li[@id='l_aud']")
    HtmlElement MUSIC_BUTTON();

    @FindBy("//li[@id='l_vid']")
    HtmlElement VIDEO_BUTTON();

    @FindBy("//a[@class='olist_item_wrap olist_item_menu olist_item_audio olist_item_wrap_on']")
    HtmlElement MUSIC_CHECK_BOX_ON();

    @FindBy("//a[@class='olist_item_wrap olist_item_menu olist_item_audio']")
    HtmlElement MUSIC_CHECK_BOX();

    @FindBy("//a[@class='olist_item_wrap olist_item_menu olist_item_video olist_item_wrap_on']")
    HtmlElement VIDEO_CHECK_BOX_ON();

    @FindBy("//a[@class='olist_item_wrap olist_item_menu olist_item_video']")
    HtmlElement VIDEO_CHECK_BOX();

    @FindBy("//div[@class='popup_box_container']//div[@class='box_controls_wrap']//button[@class='flat_button']")
    HtmlElement SAVE_BUTTON();
}
