import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex5DeleteSavedSecondArticleTest extends Methods {
    @Test
    public void deleteSavedSecondArticleTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);

        //1. Сохраняет две статьи в одну папку
        //Java статья
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

        //Kotlin статья
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Kotlin", "Kotlin", 15);
        waitForElementIsPresent(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='General-purpose programming language derived from Java']"),
                "Can not find Kotlin article", 15);
        waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='General-purpose programming language derived from Java']"),
                "Can not find Kotlin article", 15);
        WebElement titleElement1 = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Kotlin (programming language)']"), "Can not find title", 15);
        Assert.assertEquals("We see unexpected title", "Kotlin (programming language)", titleElement1.getText());
        waitForElementAndClick(By.xpath("//android.widget.TextView[@content-desc='Save']"), "", 10);
        waitForElementAndClick(By.xpath("//android.widget.TextView[@content-desc='Save']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Move from Saved to another reading list')]"), "Can not find Saved element", 10);
        waitForElementAndClick(By.xpath("//*[@text='Saved']"), "", 10);
        WebElement viewElement1 = waitForElementIsPresent(By.xpath("//*[contains(@text,'View list')]"), "Can not find View list", 15);
        Assert.assertEquals("We see unexpected title", "View list", viewElement1.getText());
        waitForElementAndClick(By.xpath("//*[contains(@text,'View list')]"), "Can not find View list", 10);

        //2. Удаляет одну из статей //Java
        waitForElementIsPresent(By.xpath("//*[contains(@text,'Java (programming language)')]"), "", 10);
        swipeElementToLeft(By.xpath("//*[contains(@text,'Java (programming language)')]"), "");

        //3. Убеждается, что вторая осталась
        waitForElementIsPresent(By.xpath("//*[contains(@text,'Kotlin (programming language)')]"), "", 10);
        WebElement result = waitForElementIsPresent(By.xpath("//*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']"), "", 15);
        Assert.assertTrue("We see unexpected title", result.getText().contains("1 of 1 article available offline"));

        //4. Переходит в неё и убеждается, что title совпадает
        waitForElementAndClick(By.xpath("//*[contains(@text,'Kotlin (programming language)')]"), "", 10);
        WebElement titleElement3 = waitForElementIsPresent(By.xpath("//*[@resource-id='pcs']//*[@text='Kotlin (programming language)']"),
                "Can not find title", 15);
        Assert.assertEquals("We see unexpected title", "Kotlin (programming language)", titleElement3.getText());
    }
}
