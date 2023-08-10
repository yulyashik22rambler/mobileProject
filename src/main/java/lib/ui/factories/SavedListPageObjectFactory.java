package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.IOS.IOSSavedListPageObject;
import lib.ui.SavedListPageObject;
import lib.ui.android.AndroidSavedListPageObject;

public class SavedListPageObjectFactory {
    public static SavedListPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSavedListPageObject(driver);
        } else
            return new IOSSavedListPageObject(driver);
    }
}
