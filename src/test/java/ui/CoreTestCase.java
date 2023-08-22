package ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase {

    protected RemoteWebDriver driver;


    @Before
    @Step("Start session and begin driver")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        rotatePortray();
        this.openWikiWebPageForMobileWeb();
    }

    @After
    @Step("End session and  exit driver")
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Step("Rotate screen")
    public void rotateScreen() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            Dimension size = driver.manage().window().getSize();
            int width = size.getWidth();
            int height = size.getHeight();

            if (height > width) {
                driver.rotate(ScreenOrientation.LANDSCAPE);
            } else {
                driver.rotate(ScreenOrientation.PORTRAIT);
            }
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Rotate into portray screen")
    public void rotatePortray() {
        if (driver instanceof RemoteWebDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    @Step("Switch into background mode")
    public void switchBackGroundMode(int timeInSeconds) {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofMillis(timeInSeconds));
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    @Step("Open WikiWebPage for mobile web in browser")
    public void openWikiWebPageForMobileWeb() {
        if (Platform.getInstance().isMw()) {
            driver.get("https://en.m.wikipedia.org");
            driver.manage().window().setSize(new Dimension(340, 640));
        } else {
            System.out.println("Method 'openWikiWebPageForMobileWeb' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

}
