package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        searchFirstInput = "xpath://*[contains(@text,'Search Wikipedia')]";
        searchResultBySubstringTpl = "xpath://*[@class='android.view.ViewGroup']//*[@text='{SUBSTRING}']";
        skipOrLoopButton = "xpath://*[@text='Skip']";
        backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        searchInput = "xpath://*[contains(@resource-id,'org.wikipedia:id/search_src_text')]";
        searchResult = "xpath://*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]";
        searchResultByTitleDescrTmpl = "xpath://*[@class='android.view.ViewGroup'][*[@text='{SUBSTRING_1}']][*[@text='{SUBSTRING_2}']]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
