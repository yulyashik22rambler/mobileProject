package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    public AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementIsPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement assertElementIsPresent(By by, String expectedText, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(by, errorMessage, timeInSeconds);
        Assert.assertEquals("We see unexpected title", expectedText, element.getText());
        return element;
    }

    public WebElement assertElementTextEqualExpected(By by, String expectedText, String errorMessage, long timeInSeconds) {
        WebElement element = driver.findElement(by);
        Assert.assertEquals("We see unexpected title", expectedText, element.getText());
        return element;

    }

    public List<WebElement> waitForElementsArePresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public Boolean waitForElementsNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClick(By by, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(by, errorMessage, timeInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKey(By by, String value, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(by, errorMessage, timeInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public boolean waitForElementsAreNotPresent(By by, String errorMessage, long timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
    }

    public WebElement waitForElementAndClear(By by, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(by, errorMessage, timeInSeconds);
        element.clear();
        return element;
    }

    public void assertElementHasText(By by, String expectedText, String errorMessage) {
        WebElement element = waitForElementIsPresent(by, errorMessage, 15);
        Assert.assertEquals(errorMessage, expectedText, element.getText());
    }

    public void assertElementsHaveText(By by, String expectedText, String errorMessage) {
        List<WebElement> elements = waitForElementsArePresent(by, errorMessage, 15);
        elements.forEach(element ->
                Assert.assertTrue(errorMessage, element.getText().contains(expectedText)));
    }

    public void swipeUp(int timeoutOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int y_start = (int) (size.height * 0.8);
        int y_end = (int) (size.height * 0.2);
        action.press(x, y_start).waitAction(timeoutOfSwipe).moveTo(x, y_end).release().perform();
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpFindElement(By by, String errorMessage, int maxSwiped) {
        int alreadySwiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwiped) {
                waitForElementNotPresent(by, "Can not find element by swiping up" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void swipeElementToLeft(By by, String errorMessage) {
        WebElement element = waitForElementIsPresent(by, errorMessage, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int low_y = upper_y + element.getSize().getHeight();

        int middle_y = (upper_y + low_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(500)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];
        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Can not get type of locator "+locatorWithType);
        }

    }
}
