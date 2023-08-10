package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        searchFirstInput = "xpath://*[contains(@text,'Search Wikipedia')]";
        searchResultBySubstringTpl = "xpath://*[@class='android.view.ViewGroup']//*[@text='{SUBSTRING}']";
        skipButton = "xpath://*[@text='Skip']";
        backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        searchInput = "xpath://*[contains(@resource-id,'org.wikipedia:id/search_src_text')]";
        searchResult = "xpath://*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]";
        searchResultByTitleDescrTmpl = "xpath://*[@class='android.view.ViewGroup'][*[@text='{SUBSTRING_1}']][*[@text='{SUBSTRING_2}']]";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }

}
