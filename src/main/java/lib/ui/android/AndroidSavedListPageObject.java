package lib.ui.android;

import lib.ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSavedListPageObject extends SavedListPageObject {
    static {
        searchResultBySubstringTpl = "xpath://*[contains(@text,'{SUBSTRING}')]";
        articleDescr = "xpath://*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']";
    }

    public AndroidSavedListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
