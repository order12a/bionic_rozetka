package selenium_cookbook.api.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import utils.Log4Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class JQuery {

    @SuppressWarnings("unchecked")
    @Test
    public void testCheckBoxesContent() {

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("http://dl.dropbox.com/u/55228056/Locators.html");

        List<String> checked = Arrays.asList(new String[]{"user128_admin", "user220_browser"});

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> elements = (List<WebElement>) js.executeScript("return jQuery.find(':checked')");

        for (WebElement element : elements) {
            assertTrue(checked.contains(element.getAttribute("id")));
            Log4Test.info(element.getAttribute("id"));
        }

    }
}
