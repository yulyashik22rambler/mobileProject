package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    public RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementIsPresent(String locator, String errorMessage, long timeInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement assertElementIsPresent(String locator, String expectedText, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(locator, errorMessage, timeInSeconds);
        Assert.assertEquals("We see unexpected title", expectedText, element.getText());
        return element;
    }

    public WebElement assertElementTextEqualExpected(String locator, String expectedText, String errorMessage, long timeInSeconds) {
        By by = this.getLocatorByString(locator);
        WebElement element = driver.findElement(by);
        Assert.assertEquals("We see unexpected title", expectedText, element.getText());
        return element;

    }

    public List<WebElement> waitForElementsArePresent(String locator, String errorMessage, long timeInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public Boolean waitForElementsNotPresent(String locator, String errorMessage, long timeInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(locator, errorMessage, timeInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKey(String locator, String value, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(locator, errorMessage, timeInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String errorMessage, long timeInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public boolean waitForElementsAreNotPresent(String locator, String errorMessage, long timeInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeInSeconds) {
        WebElement element = waitForElementIsPresent(locator, errorMessage, timeInSeconds);
        element.clear();
        return element;
    }

    public void assertElementHasText(String locator, String expectedText, String errorMessage) {
        WebElement element = waitForElementIsPresent(locator, errorMessage, 15);
        Assert.assertEquals(errorMessage, expectedText, element.getText());
    }

    public void assertElementsHaveText(String locator, String expectedText, String errorMessage) {
        List<WebElement> elements = waitForElementsArePresent(locator, errorMessage, 15);
        elements.forEach(element ->
                Assert.assertTrue(errorMessage, element.getText().contains(expectedText)));
    }

    public void swipeUp(int timeoutOfSwipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int y_start = (int) (size.height * 0.8);
            int y_end = (int) (size.height * 0.2);
            action.press(PointOption.point(x, y_start)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeoutOfSwipe)))
                    .moveTo(PointOption.point(x, y_end))
                    .release().perform();
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpFindElement(String locator, String errorMessage, int maxSwiped) {
        By by = this.getLocatorByString(locator);
        int alreadySwiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwiped) {
                waitForElementNotPresent(locator, "Can not find element by swiping up" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void swipeElementToLeft(String locator, String errorMessage) {
        WebElement element = waitForElementIsPresent(locator, errorMessage, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int low_y = upper_y + element.getSize().getHeight();

        int middle_y = (upper_y + low_y) / 2;

        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            action.press(PointOption.point(right_x, middle_y));
            action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
            if (Platform.getInstance().isAndroid()) {
                action.moveTo(PointOption.point(left_x, middle_y));
            } else {
                int offsetX = (-1 * element.getSize().getWidth());
                action.moveTo(PointOption.point(offsetX, 0));
            }
            action.release();
            action.perform();
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
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
            throw new IllegalArgumentException("Can not get type of locator " + locatorWithType);
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator) {
        int elementLocationByY = this.waitForElementIsPresent(locator, "Cannot find element" + locator, 10)
                .getLocation().getY();
        if (Platform.getInstance().isMw()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object jsResult = javascriptExecutor.executeScript("return pageYOffset");
            elementLocationByY -= Integer.parseInt(jsResult.toString());
        }
        int screenSizeByY = driver.manage().window().getSize().getHeight();
        return elementLocationByY < screenSizeByY;
    }

    public void swipeUpFindElementAppear(String locator, String errorMessage, int maxSwiped) {
        int alreadySwiped = 0;
        while (this.isElementLocatedOnTheScreen(locator)) {
            if (alreadySwiped > maxSwiped) {
                Assert.assertTrue(errorMessage, this.isElementLocatedOnTheScreen(locator));
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void clickElementToTheRightUpperCorner(String locator, String errorMessage) {
        WebElement element = this.waitForElementIsPresent(locator + "/..", errorMessage, 20);
        int rightX = element.getLocation().getX();
        int upperY = element.getLocation().getY();
        int lowY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowY) / 2;
        int width = element.getSize().getWidth();
        int pointToClickX = rightX + width - 3;
        int pointToClickY = middleY;
        if (driver instanceof AppiumDriver) {
            TouchAction touchAction = new TouchAction((AppiumDriver) driver);
            touchAction.tap(PointOption.point(pointToClickX, pointToClickY)).perform();
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollPageUp() {
        if (Platform.getInstance().isMw()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollBy(0, 250)");
        } else {
            System.out.println("Method scrollPageUp does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollWebPageTillElementNotVisible(String locator, String errorMessage, int maxSwipe) {
        int alreadySwiped = 0;
        WebElement element = this.waitForElementIsPresent(locator, errorMessage, 10);
        while (!this.isElementLocatedOnTheScreen(locator)) {
            scrollPageUp();
            ++alreadySwiped;
            if (alreadySwiped > maxSwipe) {
                Assert.assertTrue(errorMessage, element.isDisplayed());
            }
        }
    }

    public boolean isElementPresent(String locator) {
        return getAmountOfElements(locator) > 0;
    }

    private int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tryClickElementWithFewAttempts(String locator,String errorMessage,int msxAttempt) {
        int currentAttempt = 0;
        boolean isNeedMoreAttempt = true;
        while (isNeedMoreAttempt) {
            try {
                this.waitForElementAndClick(locator, errorMessage, 10);
                isNeedMoreAttempt = false;
            } catch (Exception exception) {
                System.out.println("Attempt number " + currentAttempt);
                if (currentAttempt > currentAttempt) {
                    this.waitForElementAndClick(locator, errorMessage, 10);
                }
            }
            ++currentAttempt;

        }
    }
}

