package ui.android;

import ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSavedListPageObject extends SavedListPageObject {
    static {
        SavedListPageObject.searchResultBySubstringTpl = "xpath://*[contains(@text,'{SUBSTRING}')]";
        SavedListPageObject.articleDescr = "xpath://*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']";
    }

    public AndroidSavedListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
