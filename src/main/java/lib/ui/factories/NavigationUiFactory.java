package lib.ui.factories;

import lib.Platform;
import lib.ui.IOS.IOSNavigationUi;
import lib.ui.NavigationUi;
import lib.ui.android.AndroidNavigationUi;
import lib.ui.mobile_web.MwNavigationUi;
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
