import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest extends Methods {

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



}