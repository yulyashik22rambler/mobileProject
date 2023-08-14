package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MwSearchPageObject extends SearchPageObject {

    static {
        skipOrLoopButton = "id:searchIcon";
        searchFirstInput = "xpath://div[@class='overlay-title search-header-view']/form/input[@placeholder='Search Wikipedia']";
        searchFirstInput1 ="xpath:.//button[@id='searchIcon']";
        searchInput = "xpath:.//div[@class='overlay-title search-header-view']/form/input[@placeholder='Search Wikipedia']";
        searchInput1 ="xpath:.//div[@class='overlay-title search-header-view']//input[@aria-label='Search Wikipedia']";
        searchResultBySubstringTpl = "xpath:.//div[contains(@class,'wikidata-description')][text()='{SUBSTRING}']";

        backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        searchResult = "xpath:.//div[contains(@class,'wikidata-description')][text()='Object-oriented programming language']";
        searchResultByTitleDescrTmpl = "xpath:.//li/a[contains(@data-title,'Java (programming language)')]";
    }

    String cancelButton = ".//div/button[contains(@class,'icon-only  cancel')]";

    public MwSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
