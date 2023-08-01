package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private String titleArticleTpl = "//*[@resource-id='pcs-edit-section-title-description']//../*[@class='android.widget.TextView'][contains(@text,'{SUBSTRING}')]";
    private String footerXpath = "//*[@resource-id='pcs']//*[@content-desc='View article in browser']";
    private String saveButtonXpath = "//android.widget.TextView[@content-desc='Save']";
    private String viewListButtonXpath = "//*[contains(@text,'View list')]";
    private String savedXpath = "//*[@text='Saved']";
    private String moveToAnotherSavedListXpath = "//*[contains(@text,'Move from Saved to another reading list')]";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    /* Template method */
    private String getElementXpath(String substring) {
        return titleArticleTpl.replace("{SUBSTRING}", substring);
    }
    /*  */

    public String getArticleTitle(String title) {
        WebElement titleElement = this.waitForElementIsPresent(By.xpath(getElementXpath(title)),
                "Can not find title", 60);
        return titleElement.getText();
    }

    public ArticlePageObject swipeTillFooter() {
        this.swipeUpFindElement(By.xpath(footerXpath),
                "Swipe till element footer", 20);
        return this;
    }

    public void addToSaveList() {
        this.waitForElementAndClick(By.xpath(saveButtonXpath), "", 10);
        this.waitForElementAndClick(By.xpath(saveButtonXpath), "", 10);
        this.waitForElementAndClick(By.xpath(moveToAnotherSavedListXpath), "Can not find Saved element", 10);
        this.waitForElementAndClick(By.xpath(savedXpath), "", 10);
        this.waitForElementIsPresent(By.xpath(viewListButtonXpath), "Can not find View list", 15);
    }

    public ArticlePageObject swipe(){
        this.swipeUp(2000);
        return this;
    }
}
