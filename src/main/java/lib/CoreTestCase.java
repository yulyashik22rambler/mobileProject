package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;


    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver =  Platform.getInstance().getDriver();
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


}
