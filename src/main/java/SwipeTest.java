import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwipeTest extends Methods {
    @Test
    public void swipeJavaArticleTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementIsPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Island in Indonesia']"), "", 15);
        waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Island in Indonesia']"), "", 15);
        WebElement titleElement = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Java']"), "Can not find title", 15);
        String titleAttribute = titleElement.getText();
        Assert.assertEquals("We see unexpected title", "Java", titleAttribute);
        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
    }

    @Test
    public void swipeTillFooterTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Appium", "", 15);
        waitForElementIsPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Automation for Apps']"), "", 15);
        waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Automation for Apps']"), "", 15);
        WebElement titleElement = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Appium']"), "Can not find title", 15);
        String titleAttribute = titleElement.getText();
        Assert.assertEquals("We see unexpected title", "Appium", titleAttribute);
        swipeUpFindElement(By.xpath("//*[@resource-id='pcs']//*[@content-desc='View article in browser']"),"Swipe till element footer",20);
    }
}
