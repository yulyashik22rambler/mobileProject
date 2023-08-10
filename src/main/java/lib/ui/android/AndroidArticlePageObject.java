package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        titleArticleTpl = "xpath://*[@resource-id='pcs-edit-section-title-description']//../*[@class='android.widget.TextView'][contains(@text,'{SUBSTRING}')]";
        footer = "xpath://*[@resource-id='pcs']//*[@content-desc='View article in browser']";
        saveButton = "xpath://android.widget.TextView[@content-desc='Save']";
        viewListButton = "xpath://*[contains(@text,'View list')]";
        saved = "xpath://*[@text='Saved']";
        moveToAnotherSavedList = "xpath://*[contains(@text,'Move from Saved to another reading list')]";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
