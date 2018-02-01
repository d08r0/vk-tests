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

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTest {

    public static final By ENTER_LOGIN = By.xpath("//*[@id='index_email']");
    public static final By ENTER_PASSWORD = By.xpath("//*[@id='index_pass']");
    public static final By SEND_LOGIN_BUTTON = By.xpath("//*[@id='index_login_button']");
    public static final By SEND_FRIENDS_BUTTON = By.xpath("//li[@id='l_fr']");
    public static final By SEARCH_FRIENDS = By.xpath("//input[@id='s_search']");
    public static final By WRITE_MESSAGE_BUTTON = By.xpath("//*[@class='friends_field_act']");
    public static final By ENTER_MESSAGE = By.xpath("//div[@id='mail_box_editable']");
    public static final By SEND_MESSAGE_BUTTON = By.xpath("//*[@class='flat_button fl_r mail_box_send_btn']");
    public static final By MESSAGE_BUTTON = By.xpath("//li[@id='l_msg']");
    public static final By MESSAGE_TEXT = By.xpath("//*[@class='nim-dialog--inner-text']");
    private WebDriver driver;

    static String friend = "Венди гагарина";
    static String url = "http://www.vk.com";
    static VConfig cfg = ConfigFactory.create(VConfig.class);

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

        driver.findElement(ENTER_LOGIN).sendKeys(cfg.login());
        driver.findElement(ENTER_PASSWORD).sendKeys(cfg.password());
        driver.findElement(SEND_LOGIN_BUTTON).click();

        driver.findElement(SEND_FRIENDS_BUTTON).click();
        driver.findElement(SEARCH_FRIENDS).sendKeys(friend);
        driver.findElement(WRITE_MESSAGE_BUTTON).click();

        driver.findElement(ENTER_MESSAGE).sendKeys(message);
        driver.findElement(SEND_MESSAGE_BUTTON).click();

        driver.navigate().refresh();

        driver.findElement(MESSAGE_BUTTON).click();

        assertThat(driver.findElement(MESSAGE_TEXT).getText())
                .isEqualTo(message);
    }
}
