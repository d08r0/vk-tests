package erik.indahouse;

import com.thoughtworks.selenium.webdriven.commands.ClickAt;
import io.qameta.htmlelements.WebPageFactory;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import pages.FriendsPagesHE;
import pages.HomePagesHE;
import pages.LoginPagesHE;
import pages.MessagePageHE;
import ru.yandex.qatools.allure.annotations.Title;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTestHE {

    public static final String url = "http://www.vk.com";
    public static final VConfig cfg = ConfigFactory.create(VConfig.class);

    FriendsPagesHE friendsPages;
    HomePagesHE homePages;
    LoginPagesHE loginPages;
    MessagePageHE messagePage;

    @DataProvider
    public static Object[] message() {
        return new Object[]{
                "Привет",
                "Hi",
                "Hallo",
                "Bonjour",
                "ciao",
                "hola",
                "hei",
                "szia",
                "прывітанне",
                "(:"
        };
    }

    @Before
    public void setUp() throws Exception {

        rule.getDriver().get(url);

        friendsPages = factory.get(rule.getDriver(), FriendsPagesHE.class);
        homePages = factory.get(rule.getDriver(), HomePagesHE.class);
        loginPages = factory.get(rule.getDriver(), LoginPagesHE.class);
        messagePage = factory.get(rule.getDriver(), MessagePageHE.class);
    }

    @Rule
    public VkRule rule = new VkRule();

    WebPageFactory factory = new WebPageFactory();

    @Test
    @Title("Отправить сообщение")
    @UseDataProvider("message")
    public void testTitle(String message) throws InterruptedException {

        loginPages.ENTER_LOGIN().sendKeys(cfg.login());
        loginPages.ENTER_PASSWORD().sendKeys(cfg.password());
        loginPages.SEND_LOGIN_BUTTON().click();

        homePages.SEND_FRIENDS_BUTTON().click();

        friendsPages.SEARCH_FRIENDS().sendKeys(cfg.friend());
        friendsPages.WRITE_MESSAGE_BUTTON().click();
        friendsPages.ENTER_MESSAGE().sendKeys(message);
        friendsPages.SEND_MESSAGE_BUTTON().click();

        homePages.MESSAGE_BUTTON().click();

        assertThat(messagePage.MESSAGE_TEXT().getText())
                .isEqualTo(message);
    }
}
