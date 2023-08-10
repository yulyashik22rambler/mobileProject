package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.SavedListPageObject;

public class IOSSavedListPageObject extends SavedListPageObject {
    static {
        searchResultBySubstringTpl = "xpath://*[contains(@text,'{SUBSTRING}')]";
        articleDescr = "xpath://*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']";
    }

    public IOSSavedListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
