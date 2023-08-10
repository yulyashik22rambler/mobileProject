package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.factories.ArticlePageObjectFactory;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

abstract public class SavedListPageObject extends MainPageObject {
    protected static String searchResultBySubstringTpl, articleDescr;

    public SavedListPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* Template method */
    private String getResultSearchElement(String substring) {
        return searchResultBySubstringTpl.replace("{SUBSTRING}", substring);
    }

    /*  */
    public void swipeToLeft(String articleTitle) {
        this.waitForElementIsPresent(getResultSearchElement(articleTitle), "", 10);
        this.swipeElementToLeft(getResultSearchElement(articleTitle), "");
        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(getResultSearchElement(articleTitle),"Cannot find by article title");
        }
    }

    public void checkSavedArticlesCount(String resultString) {
        WebElement result = this.waitForElementIsPresent(articleDescr, "", 15);
        Assert.assertTrue("We see unexpected title", result.getText().contains(resultString));
    }

    public void checkSavedArticleTitleIsPresent(String articleTitle) {
        this.waitForElementIsPresent(getResultSearchElement(articleTitle), "Can not find by title:" + articleTitle, 10);
    }

    public ArticlePageObject goToArticlePageClickByTitle(String articleTitle) {
        this.waitForElementAndClick(getResultSearchElement(articleTitle), "", 10);
        return ArticlePageObjectFactory.get(driver);
    }
}
