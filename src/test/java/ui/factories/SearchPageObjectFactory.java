package ui.factories;

import ui.Platform;
import ui.IOS.IOSSearchPageObject;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.mobile_web.MwSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIos()) {
            return new IOSSearchPageObject(driver);
        } else {
            return new MwSearchPageObject(driver);
        }
    }
}
