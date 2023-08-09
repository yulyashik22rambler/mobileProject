package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class ISOTestCase extends TestCase {
    protected AppiumDriver driver;
    private String appiumUrl = "http://127.0.0.1:4723/wd/hub";

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apps/Wikipedia.app");
        driver = new IOSDriver(new URL(appiumUrl), capabilities);
        rotatePortray();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    public void rotateScreen() {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        if (height > width) {
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    public void rotatePortray(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    public void switchBackGroundMode(int timeInSeconds) {
        driver.runAppInBackground(timeInSeconds);
    }
}
