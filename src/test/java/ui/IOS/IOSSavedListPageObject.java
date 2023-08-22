package ui.IOS;

import ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSavedListPageObject extends SavedListPageObject {
    static {
        SavedListPageObject.searchResultBySubstringTpl = "xpath://*[contains(@text,'{SUBSTRING}')]";
        SavedListPageObject.articleDescr = "xpath://*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']";
    }

    public IOSSavedListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
