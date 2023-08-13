package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUi extends NavigationUi {
    static {
        viewList = "xpath://*[contains(@text,'View list')]";
    }

    public IOSNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
