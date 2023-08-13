package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;


    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        rotatePortray();
        this.openWikiWebPageForMobileWeb();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

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

    public void rotatePortray() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void switchBackGroundMode(int timeInSeconds) {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(timeInSeconds);
        } else {
            System.out.println("Method rotatePortray does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
public void  openWikiWebPageForMobileWeb(){
        if (Platform.getInstance().isMw()){
            driver.get("https://en.m.wikipedia.org");
            driver.manage().window().setSize(new Dimension(340,640));
        }else {
            System.out.println("Method 'openWikiWebPageForMobileWeb' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
}

}
