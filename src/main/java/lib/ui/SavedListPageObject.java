package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SavedListPageObject extends MainPageObject {
    private String searchResultBySubstringTpl = "//*[contains(@text,'{SUBSTRING}')]";

    public SavedListPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* Template method */
    private String getResultSearchElement(String substring) {
        return searchResultBySubstringTpl.replace("{SUBSTRING}", substring);
    }

    /*  */
    public void swipeToLeft(String articleTitle) {
        this.waitForElementIsPresent(By.xpath(getResultSearchElement(articleTitle)), "", 10);
        this.swipeElementToLeft(By.xpath(getResultSearchElement(articleTitle)), "");
    }

    public void checkSavedArticlesCount(String resultString) {
        WebElement result = this.waitForElementIsPresent(By.xpath("//*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']"), "", 15);
        Assert.assertTrue("We see unexpected title", result.getText().contains(resultString));
    }

    public void checkSavedArticleTitleIsPresent(String articleTitle) {
        this.waitForElementIsPresent(By.xpath(getResultSearchElement(articleTitle)), "Can not find by title:" + articleTitle, 10);
    }

    public ArticlePageObject goToArticlePageClickByTitle(String articleTitle) {
        this.waitForElementAndClick(By.xpath(getResultSearchElement(articleTitle)), "", 10);
        return new ArticlePageObject(driver);
    }
}
