package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUi;

public class IOSNavigationUi extends NavigationUi {
    static {
        viewList = "xpath://*[contains(@text,'View list')]";
    }

    public IOSNavigationUi(AppiumDriver driver) {
        super(driver);
    }
}
