package erik.indahouse;

import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import pages.FriendsPages;
import pages.HomePages;
import pages.LoginPages;
import pages.MessagePage;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTest {


    public static final By MESSAGE_TEXT = By.xpath("//span[@class='nim-dialog--inner-text']");

    public static final String url = "http://www.vk.com";
    public static final VConfig cfg = ConfigFactory.create(VConfig.class);

    private WebDriver driver;

    LoginPages objLogin;
    HomePages objHome;
    FriendsPages objFriends;
    MessagePage objMessage;

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
    public void createDriver() {
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @After
    public void exit() {
        driver.quit();
    }

    @Test
    @UseDataProvider("message")
    public void testTitle(String message) throws InterruptedException {

        objLogin = new LoginPages(driver);
        objLogin.setLogin(cfg.login());
        objLogin.setPassword(cfg.password());
        objLogin.clickLogin();

        objHome = new HomePages(driver);
        objHome.clickFriendsButon();

        objFriends = new FriendsPages(driver);
        objFriends.setSearchFriends(cfg.friend());
        objFriends.clickWriteMessageButton();
        objFriends.setMessage(message);
        objFriends.clickSendMessageButton();

        driver.navigate().refresh();

        objHome.clickMessageButon();

        objMessage = new MessagePage(driver);


        assertThat(objMessage.getMessageText())
                .isEqualTo(message);
    }
}
