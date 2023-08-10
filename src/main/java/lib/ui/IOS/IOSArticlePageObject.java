package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        titleArticleTpl = "xpath://*[@resource-id='pcs-edit-section-title-description']//../*[@class='android.widget.TextView'][contains(@text,'{SUBSTRING}')]";
        footer = "xpath://*[@resource-id='pcs']//*[@content-desc='View article in browser']";
        saveButton = "id:'Save for late'";
        viewListButton = "xpath://*[contains(@text,'View list')]";
        saved = "xpath://*[@text='Saved']";
        moveToAnotherSavedList = "xpath://*[contains(@text,'Move from Saved to another reading list')]";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
