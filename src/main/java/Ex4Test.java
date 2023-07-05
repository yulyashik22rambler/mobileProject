import org.junit.Test;
import org.openqa.selenium.By;

public class Ex4Test extends Methods {
    @Test
    public void ex4CheckWordInSearchResultsTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementsArePresent(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]"),
                "Elements should be preset on a page", 15);
        assertElementsHaveText(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]"),
                "Java", "Elements should have the same text - Java");
    }
}
