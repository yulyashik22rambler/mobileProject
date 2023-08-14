package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwArticlePageObject extends ArticlePageObject {

    static {
        titleArticleTpl = "xpath:.//h1/span[contains(text(),'{SUBSTRING}')]";
        footer = "xpath:.//footer[@class='mw-footer minerva-footer']";
        saveButton = "xpath:.//a[@role='button'][@id='ca-watch']";
        saved = "xpath:.//a[contains(@title,'Add this page to your watchlist')]";
        removeFromMySaveList = "xpath:.//a[contains(@title,'Unwatch')]";
    }

    public MwArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
