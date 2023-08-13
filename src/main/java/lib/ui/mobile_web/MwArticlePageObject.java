package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwArticlePageObject extends ArticlePageObject {

    static {
        titleArticleTpl = "xpath:.//h1/span[contains(text(),'{SUBSTRING}')]";
        footer = "xpath:.//footer[@class='mw-footer minerva-footer']";
        saveButton = "id:ca-watch";
        // viewListButton = "xpath://*[contains(@text,'View list')]";
        saved =  "xpath:.//a[contains(@title,'Add this page to your watchlist')]";;
        //   moveToAnotherSavedList = "xpath://*[contains(@text,'Move from Saved to another reading list')]";
        removeFromMySaveList = "xpath:.//a[contains(@title,'Remove this page from your watchlist')]";
    }

    public MwArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
