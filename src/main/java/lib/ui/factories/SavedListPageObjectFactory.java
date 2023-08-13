package lib.ui.factories;

import lib.Platform;
import lib.ui.IOS.IOSSavedListPageObject;
import lib.ui.SavedListPageObject;
import lib.ui.android.AndroidSavedListPageObject;
import lib.ui.mobile_web.MwSavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SavedListPageObjectFactory {
    public static SavedListPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSavedListPageObject(driver);
        } else if (Platform.getInstance().isIos()) {
            return new IOSSavedListPageObject(driver);
        } else {
            return new MwSavedListPageObject(driver);
        }
    }
}
