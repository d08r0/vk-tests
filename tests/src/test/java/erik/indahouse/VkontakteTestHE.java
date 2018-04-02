package erik.indahouse;

import com.thoughtworks.selenium.webdriven.commands.ClickAt;
import io.qameta.htmlelements.WebPageFactory;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raml.parser.rule.SimpleRule;
import pages.FriendsPages;
import pages.FriendsPagesHE;
import pages.HomePages;
import pages.HomePagesHE;
import pages.LoginPages;
import pages.LoginPagesHE;
import pages.MessagePage;

import java.util.concurrent.TimeUnit;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.runners.model.Statement;
import org.junit.ClassRule;
import pages.MessagePageHE;
import ru.yandex.qatools.allure.annotations.Title;


import javax.annotation.OverridingMethodsMustInvokeSuper;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTestHE {
//private  WebDriver driver = new ChromeDriver();





//========
//    @Rule
//    public ExternalResource fixtures = new ExternalResource() {
//        @Override
//        protected void before() throws Throwable {
//            driver = new ChromeDriver();
//            objLogin = new LoginPages(driver);
//            objHome = new HomePages(driver);
//            objFriends = new FriendsPages(driver);
//            objMessage = new MessagePage(driver);
//
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.get(url);
//        }
//
//        @Override
//        protected void after() {
//            driver.quit();
//        }
//    };

//========


//    public static final String url = "http://www.vk.com";
    public static final VConfig cfg = ConfigFactory.create(VConfig.class);


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


//    @Before
//    public void createDriver() {
//        driver = new ChromeDriver();
//
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(url);
//    }

//    @After
//    public void exit() {
//        driver.quit();
//    }


//
//    private CardPage cardPage() {
//        WebPageFactory factory = new WebPageFactory();
//        MainPage page = factory.get(driver, MainPage.class);
//
//
//        return cardPage;
//    }


    @Rule
    public  VkRule rule = new VkRule();

    WebDriver driver;

    @Test
    @Title("Отправить сообщение")
    @UseDataProvider("message")
    public void testTitle(String message) throws InterruptedException {

        WebPageFactory factory = new WebPageFactory();
        FriendsPagesHE friendsPages = factory.get(driver, FriendsPagesHE.class);
        HomePagesHE homePages = factory.get(driver, HomePagesHE.class);
        LoginPagesHE loginPages = factory.get(driver, LoginPagesHE.class);
        MessagePageHE messagePage = factory.get(driver, MessagePageHE.class);

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
