package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObject extends MainPageObject {
    protected static String skipOrLoopButton, searchFirstInput, searchInput, searchResultBySubstringTpl, backButton, searchResult, searchResultByTitleDescrTmpl;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* Template methods */
    private String getResultSearchElement(String substring) {
        return searchResultBySubstringTpl.replace("{SUBSTRING}", substring);
    }

    private String getResultSearchResultElement(String title, String description) {
        return searchResultByTitleDescrTmpl.replace("{SUBSTRING_1}", title).replace("{SUBSTRING_2}", description);
    }
    /*  */

    public SearchPageObject clickSkipButton() {
        this.waitForElementAndClick(skipOrLoopButton, "Can not find Skip button", 10);
        return this;
    }

    public SearchPageObject clickBackButton() {
        this.waitForElementAndClick(backButton, "Can not find Back button", 10);
        return this;
    }

    public SearchPageObject initSearchInput() {
        this.waitForElementIsPresent(searchFirstInput, "Can not find element search init", 10);
        this.waitForElementAndClick(searchFirstInput, "Can not find element search init", 10);
        return this;
    }

    public SearchPageObject typeSearchLineAndSendKey(String searchText) {
        this.waitForElementAndSendKey(searchFirstInput, searchText, "Can not find element search init", 10);
        return this;
    }

    public SearchPageObject waitForSearchResult(String subString) {
        this.waitForElementIsPresent(getResultSearchElement(subString), "Can not find search result elements", 15);
        return this;
    }

    public void clickByArticleBySubstring(String subString) {
        this.waitForElementAndClick(getResultSearchElement(subString),
                "Can not find search result elements", 35);
    }

    public SearchPageObject waitForCancelButtonAppear() {
        this.waitForElementIsPresent(backButton, "Can not find Navigate back button", 15);
        return this;
    }

    public SearchPageObject waitForCancelButtonDisappear() {
        this.waitForElementNotPresent(backButton, "Can Navigate back button", 15);
        return this;
    }

    public void assertSearchInputHasText(String searchPhrase) {
        this.assertElementHasText(searchInput, searchPhrase, "Attribute 'text' does not contains expected value");
    }

    public SearchPageObject checkElementsOfSearchResultArePresent() {
        this.waitForElementsArePresent(searchResult, "Elements is=n search result are not present", 15);
        return this;
    }

    public SearchPageObject clearSearchInput() {
        this.waitForElementAndClear(searchInput, "Can not clear field", 10);
        return this;
    }

    public SearchPageObject checkNoElementsOfSearchResult() {
        this.waitForElementsAreNotPresent(searchResult, "Search results should not be presented", 10);
        return this;
    }

    public void elementsInSearchResultHaveText(String text) {
        this.assertElementsHaveText(searchResult, text, "Elements should have the same text - Java");
    }

    public void checkBackButtonIsNotPresent() {
        this.waitForElementNotPresent(backButton, "Element should not be presented", 10);
    }

    public SearchPageObject waitForElementByTitleAndDescription(String title, String description) {
        this.waitForElementIsPresent(getResultSearchResultElement(title, description),
                "Can not find Search result by title and description", 15);
        return this;
    }

}
