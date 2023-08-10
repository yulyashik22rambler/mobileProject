package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUi;

public class AndroidNavigationUi extends NavigationUi {
    static {
        viewList = "xpath://*[contains(@text,'View list')]";
    }

    public AndroidNavigationUi(AppiumDriver driver) {
        super(driver);
    }
}
