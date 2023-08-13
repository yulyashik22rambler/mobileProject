package lib.ui.IOS;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        titleArticleTpl = "xpath://*[@resource-id='pcs-edit-section-title-description']//../*[@class='android.widget.TextView'][contains(@text,'{SUBSTRING}')]";
        footer = "xpath://*[@resource-id='pcs']//*[@content-desc='View article in browser']";
        saveButton = "id:'Save for late'";
        viewListButton = "xpath://*[contains(@text,'View list')]";
        saved = "xpath://*[@text='Saved']";
        moveToAnotherSavedList = "xpath://*[contains(@text,'Move from Saved to another reading list')]";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
