package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String titleArticleTpl, footer, saveButton, viewListButton, saved, moveToAnotherSavedList;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    /* Template method */
    protected static String getElementXpath(String substring) {
        return titleArticleTpl.replace("{SUBSTRING}", substring);
    }
    /*  */

    public String getArticleTitle(String title) {
        WebElement titleElement = this.waitForElementIsPresent(getElementXpath(title), "Can not find title", 60);
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getText();
        } else {
            return titleElement.getAttribute("name");
        }
    }

    public ArticlePageObject swipeTillFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpFindElement(footer, "Swipe till element footer", 50);
        } else {
            this.swipeUpFindElementAppear(footer, "Swipe till element footer", 50);
        }
        return this;
    }

    public void addToSaveList() {
        this.waitForElementAndClick(saveButton, "Can not find and click on " + saveButton, 10);
        this.waitForElementAndClick(saveButton, "Can not find and click on " + saveButton, 10);
        this.waitForElementAndClick(moveToAnotherSavedList, "Can not find and click on " + moveToAnotherSavedList, 10);
        this.waitForElementAndClick(saved, "Can not find and click on " + saved, 10);
        this.waitForElementIsPresent(viewListButton, "Can not find View list", 15);
    }

    public ArticlePageObject swipe() {
        this.swipeUp(2000);
        return this;
    }

    public void addArticleToMySaved() {
        this.waitForElementAndClick(saved, "Can not find and click on " + saved, 10);
    }
}
