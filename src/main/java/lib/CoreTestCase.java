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

public class CoreTestCase extends TestCase {
    private static String platformAndroid = "android";
    private static String platformIOS = "IOS";
    private static String appiumUrl = "http://127.0.0.1:4723/wd/hub";
    protected AppiumDriver driver;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        if (platform.equals(platformAndroid)) {
            driver = new AndroidDriver(new URL(appiumUrl), capabilities);
        } else if (platform.equals(platformIOS)) {
            driver = new IOSDriver(new URL(appiumUrl), capabilities);
        } else {
            throw new Exception("Can not run platform from env");
        }
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

    public void rotatePortray() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void switchBackGroundMode(int timeInSeconds) {
        driver.runAppInBackground(timeInSeconds);
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equals(platformAndroid)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apks/org.wikipedia.apk");
        } else {
            if (platform.equals(platformIOS)) {
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("deviceName", "iPhone SE");
                capabilities.setCapability("platformVersion", "11.3");
                capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apps/Wikipedia.app");
            } else {
                throw new Exception("Can not run platform from env");
            }
        }
        return capabilities;
    }
}
