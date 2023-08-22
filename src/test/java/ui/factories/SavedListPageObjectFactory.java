package ui.factories;

import ui.Platform;
import ui.IOS.IOSSavedListPageObject;
import ui.SavedListPageObject;
import ui.android.AndroidSavedListPageObject;
import ui.mobile_web.MwSavedListPageObject;
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
