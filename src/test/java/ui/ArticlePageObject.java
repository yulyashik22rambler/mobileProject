package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String titleArticleTpl, footer, saveButton, viewListButton, saved, moveToAnotherSavedList,
            removeFromMySaveList;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* Template method */
    protected static String getElementXpath(String substring) {
        return titleArticleTpl.replace("{SUBSTRING}", substring);
    }
    /*  */

    public String getArticleTitle(String title) {
        WebElement titleElement = this.waitForElementIsPresent(getElementXpath(title), "Can not find title", 60);
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMw()) {
            return titleElement.getText();
        } else {
            return titleElement.getAttribute("name");
        }
    }

    public ArticlePageObject swipeTillFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpFindElement(footer, "Swipe till element footer", 50);
        } else if (Platform.getInstance().isIos()) {
            this.swipeUpFindElementAppear(footer, "Swipe till element footer", 50);
        } else {
            this.scrollWebPageTillElementNotVisible(footer, "Swipe till element footer", 100);
        }
        return this;
    }

    public void addToSaveList() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(saveButton, "Can not find and click on " + saveButton, 10);
            this.waitForElementAndClick(saveButton, "Can not find and click on " + saveButton, 10);
            this.waitForElementAndClick(moveToAnotherSavedList, "Can not find and click on " + moveToAnotherSavedList, 10);
            this.waitForElementAndClick(saved, "Can not find and click on " + saved, 10);
            this.waitForElementIsPresent(viewListButton, "Can not find View list", 15);
        } else if (Platform.getInstance().isIos()) {
            this.waitForElementAndClick(saved, "Can not find and click on saved", 10);
        } else {
            this.removeArticleFromSavedIfItAdded();
            sleep(2000);
            this.waitForElementAndClick(saveButton, "Can not find and click on saved", 10);
        }
    }

    public ArticlePageObject swipe() {
        this.swipeUp(2000);
        return this;
    }

    public void removeArticleFromSavedIfItAdded() {
        if (isElementPresent(removeFromMySaveList)) {
            this.waitForElementAndClick(removeFromMySaveList, "Can not find and click on removeFromMySaveList", 10);
           // sleep(2000);
            this.waitForElementIsPresent(saveButton, "Can not find save button", 10);
        }
    }
}
