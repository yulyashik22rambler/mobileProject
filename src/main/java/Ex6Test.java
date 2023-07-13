import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex6Test extends Methods {
    @Test
    public void checkArticleTitleTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Maradona", "", 15);
        waitForElementIsPresent(By.xpath("//*[@text='2018 film']"),
                "Can not find descriprion", 15);
        waitForElementAndClick(By.xpath("//*[@text='2018 film']"),
                "Can not find title", 15);
        assertElementPresent(By.xpath("//*[@resource-id='pcs']//*[contains(@text,'a (2018 film)')]"),"Maradona (2018 film)",
                "Can not find title of article",0);
    }
}
