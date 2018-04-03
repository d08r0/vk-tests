package erik.indahouse;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FriendsPages;
import pages.HomePages;
import pages.LoginPages;
import pages.MessagePage;

import java.util.concurrent.TimeUnit;

import static erik.indahouse.VkontakteTest.url;


/**
 * Created by scrooge on 19.02.2018.
 */


public class VkRule extends ExternalResource {
    private WebDriver driver;

    public VkRule(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void before() {

//        driver = new ChromeDriver();
        driver.get(url);

    }

    @Override
    protected void after() {

        driver.quit();

    }
}
