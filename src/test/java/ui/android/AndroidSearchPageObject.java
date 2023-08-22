package ui.android;

import ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SearchPageObject.searchFirstInput = "xpath://*[contains(@text,'Search Wikipedia')]";
        SearchPageObject.searchResultBySubstringTpl = "xpath://*[@class='android.view.ViewGroup']//*[@text='{SUBSTRING}']";
        SearchPageObject.skipOrLoopButton = "xpath://*[@text='Skip']";
        SearchPageObject.backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        SearchPageObject.searchInput = "xpath://*[contains(@resource-id,'org.wikipedia:id/search_src_text')]";
        SearchPageObject.searchResult = "xpath://*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]";
        SearchPageObject.searchResultByTitleDescrTmpl = "xpath://*[@class='android.view.ViewGroup'][*[@text='{SUBSTRING_1}']][*[@text='{SUBSTRING_2}']]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
