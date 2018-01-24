package erik.indahouse;

import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTest {

    private WebDriver driver;

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
    }

    @Test
    @UseDataProvider("message")
    public void TestTitle(String message) {

        String friend = "Артем Ерошенко";

        VConfig cfg = ConfigFactory.create(VConfig.class);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.vk.com");

        //Авторизация
        WebElement login = driver.findElement(By.id("index_email"));
        login.sendKeys(cfg.LOGIN());
        WebElement password = driver.findElement(By.id("index_pass"));
        password.sendKeys(cfg.PASSWORD());
        driver.findElement(By.id("index_login_button")).click();

        //Поиск друга
        driver.findElement(By.id("l_fr")).click();
        driver.findElement(By.id("s_search")).sendKeys(friend);

        //Отправка сообщения
        driver.findElement(By.xpath("//*[@class='friends_field_act']")).click();
        driver.findElement(By.id("mail_box_editable")).sendKeys(message);
        driver.findElement(By.id("mail_box_send")).click();

        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("mail_box_send")));
    }

    @After
    public void setup() {
        driver.quit();
    }
}