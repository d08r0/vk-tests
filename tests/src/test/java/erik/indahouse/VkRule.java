package erik.indahouse;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static erik.indahouse.VkontakteTest.url;


/**
 * Created by scrooge on 19.02.2018.
 */


public class VkRule extends ExternalResource {
    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    @Override
    protected void before() {
        driver = new ChromeDriver();
    }

    @Override
    protected void after() {

        driver.quit();

    }
}
