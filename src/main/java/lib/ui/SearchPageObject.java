package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private String searchFirstInputXpath = "//*[contains(@text,'Search Wikipedia')]";
    private String searchResultBySubstringTpl = "//*[@class='android.view.ViewGroup']//*[@text='{SUBSTRING}']";
    private String skipButtonXpath = "//*[@text='Skip']";
    private String backButtonXpath = "//android.widget.ImageButton[@content-desc='Navigate up']";
    private String searchInputXpath = "//*[contains(@resource-id,'org.wikipedia:id/search_src_text')]";
    private String searchResultXpath = "//*[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* Template method */
    private String getResultSearchElement(String substring) {
        return searchResultBySubstringTpl.replace("{SUBSTRING}", substring);
    }
    /*  */

    public SearchPageObject clickSkipButton() {
        this.waitForElementAndClick(By.xpath(skipButtonXpath),
                "Can not find Skip button", 10);
        return this;
    }

    public SearchPageObject clickBackButton() {
        this.waitForElementAndClick(By.xpath(backButtonXpath),
                "Can not find Back button", 10);
        return this;
    }

    public SearchPageObject initSearchInput() {
        this.waitForElementIsPresent(By.xpath(searchFirstInputXpath),
                "Can not find element search init", 10);
        this.waitForElementAndClick(By.xpath(searchFirstInputXpath),
                "Can not find element search init", 10);
        return this;
    }

    public SearchPageObject typeSearchLine(String searchText) {
        this.waitForElementAndSendKey(By.xpath(searchFirstInputXpath), searchText,
                "Can not find element search init", 10);
        return this;
    }

    public SearchPageObject waitForSearchResult(String subString) {
        this.waitForElementIsPresent(By.xpath(getResultSearchElement(subString)),
                "Can not find search result elements", 15);
        return this;
    }

    public void clickByArticleBySubstring(String subString) {
        this.waitForElementAndClick(By.xpath(getResultSearchElement(subString)),
                "Can not find search result elements", 35);
    }

    public SearchPageObject waitForCancelButtonAppear() {
        this.waitForElementIsPresent(By.xpath(backButtonXpath),
                "Can not find Navigate back button", 15);
        return this;
    }

    public SearchPageObject waitForCancelButtonDisappear() {
        this.waitForElementNotPresent(By.xpath(backButtonXpath),
                "Can Navigate back button", 15);
        return this;
    }

    public void assertSearchInputHasText(String searchPhrase) {
        this.assertElementHasText(By.xpath(searchInputXpath), searchPhrase,
                "Attribute 'text' does not contains expected value");
    }

    public SearchPageObject checkElementsOfSearchResultArePresent() {
        this.waitForElementsArePresent(By.xpath(searchResultXpath),
                "Elements is=n search result are not present", 15);
        return this;
    }

    public SearchPageObject clearSearchInput() {
        this.waitForElementAndClear(By.xpath(searchInputXpath),
                "Can not clear field", 10);
        return this;
    }

    public SearchPageObject checkNoElementsOfSearchResult() {
        this.waitForElementsAreNotPresent(By.xpath(searchResultXpath), "Search results should not be presented", 10);
        return this;
    }

    public void elementsInSearchResultHaveText(String text) {
        this.assertElementsHaveText(By.xpath(searchResultXpath), text, "Elements should have the same text - Java");
    }

    public void checkBackButtonIsNotPresent() {
        this.waitForElementNotPresent(By.xpath(backButtonXpath), "Element should not be presented", 10);
    }

}
