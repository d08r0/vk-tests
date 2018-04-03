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


import javax.annotation.OverridingMethodsMustInvokeSuper;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTest {
//private  WebDriver driver = new ChromeDriver();

//    @Rule
//    public  VkRule rule = new VkRule();



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



    public static final By MUSIC = By.xpath("//li[@id='l_aud']");
    public static final By VIDEO = By.xpath("//li[@id='l_vid']");

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


//    @Before
//    public void createDriver() {
//        driver = new ChromeDriver();
//
//        objLogin = new LoginPages(driver);
//        objHome = new HomePages(driver);
//        objFriends = new FriendsPages(driver);
//        objMessage = new MessagePage(driver);
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(url);
//    }
//
//    @After
//    public void exit() {
//        driver.quit();
//    }

    @Test
    @UseDataProvider("message")
    public void testTitle(String message) throws InterruptedException {

        objLogin.setLogin(cfg.login());
        objLogin.setPassword(cfg.password());
        objLogin.clickLogin();

        objHome.clickFriendsButon();

        objFriends.setSearchFriends(cfg.friend());
        objFriends.clickWriteMessageButton();
        objFriends.setMessage(message);
        objFriends.clickSendMessageButton();

        driver.navigate().refresh();

        objHome.clickMessageButon();

        assertThat(objMessage.getMessageText())
                .isEqualTo(message);
    }

    @Test
    public void testRemoveCategories() {

        Actions builder = new Actions(driver);

        objLogin.setLogin(cfg.login());
        objLogin.setPassword(cfg.password());
        objLogin.clickLogin();

        objHome.clickMenuSettingButon();

        builder.moveToElement(objHome.MusicCheckBoxOn()).click().perform();
        builder.moveToElement(objHome.VideoCheckBoxOn()).click().perform();

        builder.moveToElement(objHome.SaveButton()).click().perform();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(MUSIC)));

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(VIDEO)));
    }

    @Test
    public void testAddCategories() {


        Actions builder = new Actions(driver);

        objLogin.setLogin(cfg.login());
        objLogin.setPassword(cfg.password());
        objLogin.clickLogin();

        objHome.clickMenuSettingButon();

        builder.moveToElement(objHome.MusicCheckBoxOff()).click().perform();
        builder.moveToElement(objHome.VideoCheckBoxOff()).click().perform();

        builder.moveToElement(objHome.SaveButton()).click().perform();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(MUSIC));

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(VIDEO));
    }
}
