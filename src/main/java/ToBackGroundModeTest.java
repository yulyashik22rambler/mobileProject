import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ToBackGroundModeTest extends Methods {
    @Test
    public void articleNavigateTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementIsPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"), "", 15);
        WebElement titleElement = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Java (programming language)']"), "Can not find title", 15);
        Assert.assertEquals("We see unexpected title", "Java (programming language)", titleElement.getText());
        switchBackGroundMode(2);
        titleElement = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Java (programming language)']"), "Can not find title", 15);
        Assert.assertEquals("We see unexpected title", "Java (programming language)", titleElement.getText());
    }
}
