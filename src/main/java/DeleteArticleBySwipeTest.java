import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteArticleBySwipeTest extends Methods {
    @Test
    public void articleNavigateTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementIsPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        WebElement titleElement = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Java (programming language)']"), "Can not find title", 15);
        Assert.assertEquals("We see unexpected title", "Java (programming language)", titleElement.getText());

        waitForElementAndClick(By.xpath("//android.widget.TextView[@content-desc='Save']"), "", 10);
        waitForElementAndClick(By.xpath("//android.widget.TextView[@content-desc='Save']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Move from Saved to another reading list')]"), "Can not find Saved element", 10);
        waitForElementAndClick(By.xpath("//*[@text='Saved']"), "", 10);
        WebElement viewElement = waitForElementIsPresent(By.xpath("//*[contains(@text,'View list')]"), "Can not find View list", 15);

        Assert.assertEquals("We see unexpected title", "View list", viewElement.getText());
        waitForElementAndClick(By.xpath("//*[contains(@text,'View list')]"), "Can not find View list", 10);

        waitForElementIsPresent(By.xpath("//*[contains(@text,'Java (programming language)')]"), "", 10);
        swipeElementToLeft(By.xpath("//*[contains(@text,'Java (programming language)')]"), "");
        WebElement result = waitForElementIsPresent(By.xpath("//*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']"),"",15);
        Assert.assertEquals("We see unexpected title", "0 of 0 articles available offline", result.getText());
    }
}
