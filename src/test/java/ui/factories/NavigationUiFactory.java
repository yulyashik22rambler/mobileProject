package ui.factories;

import ui.Platform;
import ui.IOS.IOSNavigationUi;
import ui.NavigationUi;
import ui.android.AndroidNavigationUi;
import ui.mobile_web.MwNavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUiFactory {
    public static NavigationUi get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUi(driver);
        } else if (Platform.getInstance().isIos()) {
            return new IOSNavigationUi(driver);
        } else {
            return new MwNavigationUi(driver);
        }
    }
}
