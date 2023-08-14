package lib.ui.mobile_web;

import lib.ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwSavedListPageObject extends SavedListPageObject {
    static {
        searchResultBySubstringTpl = "xpath://li[contains(@title,'{SUBSTRING}')]";
        articleDescr = "xpath:.//div[@class='info empty-page']/p";
    }

    public MwSavedListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
