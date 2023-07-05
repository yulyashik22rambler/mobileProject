import org.junit.Test;
import org.openqa.selenium.By;

public class Ex2Test extends Methods {
    @Test
    public void searchFieldContainsTextTest() {
        waitForElementAndClick(By.xpath("//*[@text='Skip']"), "", 10);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Can not find field", 10);
        waitForElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Search smth", "", 15);
        assertElementHasText(By.xpath("//*[contains(@resource-id,'org.wikipedia:id/search_src_text')]"), "Search smth",
                "Attribute 'text' does not contains expected value");
    }
}
