import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Methods extends Initial {

    protected WebElement waitForElementPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitForElementsArePresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected Boolean waitForElementsNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected WebElement waitForElementAndClick(By by, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeInSeconds);
        element.click();
        return element;
    }

    protected WebElement waitForElementAndSendKey(By by, String value, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeInSeconds);
        element.sendKeys(value);
        return element;
    }

    protected boolean waitForElementNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected boolean waitForAllElementAreNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
    }
    protected WebElement waitForElementAndClear(By by, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeInSeconds);
        element.clear();
        return element;
    }

    protected void assertElementHasText(By by, String expectedText, String errorMessage) {
        WebElement element = waitForElementPresent(by, errorMessage, 15);
        Assert.assertEquals(errorMessage, expectedText, element.getText());
    }


}
