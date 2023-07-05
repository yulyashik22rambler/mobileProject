import org.junit.Test;
import org.openqa.selenium.By;

public class Ex3Test extends Methods{
    @Test
    public void ex3SearchAndCancelTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "", 15);
        waitForElementsArePresent(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]"), "", 15);
        waitForElementAndClear(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/search_src_text')]"), "Can not clear field", 10);
        waitForElementsAreNotPresent(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]"), "Search results should not be presented", 10);
    }
}
