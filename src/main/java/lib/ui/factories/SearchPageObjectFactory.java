package lib.ui.factories;

import lib.Platform;
import lib.ui.IOS.IOSSearchPageObject;
import lib.ui.SearchPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.mobile_web.MwSearchPageObject;
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
