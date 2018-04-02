package pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import org.openqa.selenium.By;

public interface  MessagePageHE extends WebPage {

    @FindBy("//span[@class='nim-dialog--inner-text']")
    HtmlElement MESSAGE_TEXT();

}
