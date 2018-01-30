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

import javax.rmi.CORBA.Util;
import java.util.Random;


import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by scrooge on 22.01.18.
 */

@RunWith(DataProviderRunner.class)
public class VkontakteTest {

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
    }

    @After
    public void exit() {
        driver.quit();
    }

    @Test
    @UseDataProvider("message")
    public void TestTitle(String message) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        //Авторизация
        WebElement login1 = driver.findElement(By.id("index_email"));
        login1.sendKeys(cfg.login());
        WebElement password1 = driver.findElement(By.id("index_pass"));
        password1.sendKeys(cfg.password());
        driver.findElement(By.id("index_login_button")).click();

        //Поиск друга
        driver.findElement(By.id("l_fr")).click();
        driver.findElement(By.id("s_search")).sendKeys(friend);

        //Отправка сообщения
        driver.findElement(By.xpath("//*[@class='friends_field_act']")).click();
        driver.findElement(By.xpath("//div[@id='mail_box_editable']")).sendKeys(message);


        driver.findElement(By.xpath("//*[@class='flat_button fl_r mail_box_send_btn']")).click();

        driver.navigate().refresh();

        driver.findElement(By.xpath("//li[@id='l_msg']")).click();

        assertThat(driver.findElement(By.xpath("//*[@class='nim-dialog--inner-text']")).getText())
                .isEqualTo(message);
    }
}