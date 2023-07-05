import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        System.out.println("First run test");
    }

    @Test
    public void testCancelSearchTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "Can not find 'Skip' button", 10);
        waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"), "Can not find 'Search container'", 10);
        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "Can not find 'Search container'", 10);
        waitForElementNotPresent(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "'Search container' should not be presented", 10);
    }

    @Test
    public void compareArticleTitleTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        WebElement titleElement = waitForElementPresent(By.xpath("//android.view.View[@content-desc='Java (programming language)']"), "Can not find title", 15);
        String titleAttribute = titleElement.getAttribute("content-desc");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", titleAttribute);
    }

    @Test
    public void putTextAndClearTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Can not find field", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementAndClear(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/search_src_text')]"), "Can not clear field", 10);
        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "Can not find 'Search container'", 10);
        waitForElementNotPresent(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "'Search container' should not be presented", 10);
    }

    @Test
    public void searchFieldContainsTextTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Can not find field", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Search smth", "", 15);
        assertElementHasText(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/search_src_text')]"), "Search smth",
                "Attribute 'text' does not contains expected value");
    }

    private WebElement waitForElementPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    private WebElement waitForElementAndClick(By by, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKey(By by, String value, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeInSeconds);
        element.clear();
        return element;
    }

    private void assertElementHasText(By by, String expectedText, String errorMessage) {
        WebElement element = waitForElementPresent(by, errorMessage, 15);
        Assert.assertEquals(errorMessage, expectedText, element.getText());
    }
}