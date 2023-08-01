package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private String appiumUrl = "http://127.0.0.1:4723/wd/hub";

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
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
