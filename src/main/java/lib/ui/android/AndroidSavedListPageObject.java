package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SavedListPageObject;

public class AndroidSavedListPageObject extends SavedListPageObject {
    static {
        searchResultBySubstringTpl = "xpath://*[contains(@text,'{SUBSTRING}')]";
        articleDescr = "xpath://*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']";
    }

    public AndroidSavedListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
