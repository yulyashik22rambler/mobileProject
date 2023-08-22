package ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObject extends MainPageObject {
    protected static String skipOrLoopButton, searchFirstInput,searchFirstInput1, searchInput, searchInput1,
            searchResultBySubstringTpl, backButton, searchResult, searchResultByTitleDescrTmpl;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* Template methods */
    @Step("getResultSearchElement")
    private String getResultSearchElement(String substring) {
        return searchResultBySubstringTpl.replace("{SUBSTRING}", substring);
    }
    @Step("getResultSearchResultElement")
    private String getResultSearchResultElement(String title, String description) {
        return searchResultByTitleDescrTmpl.replace("{SUBSTRING_1}", title).replace("{SUBSTRING_2}", description);
    }
    /*  */
    @Step("clickSkipButton")
    public SearchPageObject clickSkipButton() {
        this.waitForElementAndClick(skipOrLoopButton, "Can not find Skip button", 10);
        return this;
    }
    @Step("clickBackButton")
    public SearchPageObject clickBackButton() {
        this.waitForElementAndClick(backButton, "Can not find Back button", 10);
        return this;
    }
    @Step("initSearchInput")
    public SearchPageObject initSearchInput() {
        this.waitForElementIsPresent(searchFirstInput, "Can not find element search init", 10);
        this.waitForElementAndClick(searchFirstInput, "Can not find element search init", 10);
        return this;
    }
    @Step("initSearchInputMb")
    public SearchPageObject initSearchInputMb() {
        if (Platform.getInstance().isMw()) {
            this.waitForElementIsPresent(searchFirstInput1, "Can not find element search init", 10);
            this.waitForElementAndClick(searchFirstInput1, "Can not find element search init", 10);
        } else {
            this.waitForElementIsPresent(searchFirstInput, "Can not find element search init", 10);
            this.waitForElementAndClick(searchFirstInput, "Can not find element search init", 10);
        }
        return this;
    }
    @Step("typeSearchLineAndSendKey")
    public SearchPageObject typeSearchLineAndSendKey(String searchText) {
        this.waitForElementAndSendKey(searchFirstInput, searchText, "Can not find element search init", 10);
        return this;
    }
    @Step("typeSearchLineAndSendKeyMb")
    public SearchPageObject typeSearchLineAndSendKeyMb(String searchText) {
        if (Platform.getInstance().isMw()) {
            this.waitForElementAndSendKey(searchInput1, searchText, "Can not find element search init", 10);
        } else {
            this.waitForElementAndSendKey(searchFirstInput, searchText, "Can not find element search init", 10);
        }
        return this;
    }

    @Step("waitForSearchResult for {0}")
    public SearchPageObject waitForSearchResult(String subString) {
        this.waitForElementIsPresent(getResultSearchElement(subString), "Can not find search result elements", 15);
        return this;
    }
    @Step("clickByArticleBySubstring for {0}")
    public void clickByArticleBySubstring(String subString) {
        this.waitForElementAndClick(getResultSearchElement(subString),
                "Can not find search result elements", 35);
    }
    @Step("waitForCancelButtonAppear for {0}")
    public SearchPageObject waitForCancelButtonAppear() {
        this.waitForElementIsPresent(backButton, "Can not find Navigate back button", 15);
        return this;
    }
    @Step("waitForCancelButtonDisappear for {0}")
    public SearchPageObject waitForCancelButtonDisappear() {
        this.waitForElementNotPresent(backButton, "Can Navigate back button", 15);
        return this;
    }
    @Step("assertSearchInputHasText for {0}")
    public void assertSearchInputHasText(String searchPhrase) {
        this.assertElementHasText(searchInput, searchPhrase, "Attribute 'text' does not contains expected value");
    }
    @Step("checkElementsOfSearchResultArePresent for {0}")
    public SearchPageObject checkElementsOfSearchResultArePresent() {
        this.waitForElementsArePresent(searchResult, "Elements is=n search result are not present", 15);
        return this;
    }
    @Step("checkElementsOfSearchResultArePresent")
    public SearchPageObject clearSearchInput() {
        this.waitForElementAndClear(searchInput, "Can not clear field", 10);
        return this;
    }
    @Step("checkNoElementsOfSearchResult")
    public SearchPageObject checkNoElementsOfSearchResult() {
        this.waitForElementsAreNotPresent(searchResult, "Search results should not be presented", 10);
        return this;
    }
    @Step("checkNoElementsOfSearchResult for {0}")
    public void elementsInSearchResultHaveText(String text) {
        this.assertElementsHaveText(searchResult, text, "Elements should have the same text - Java");
    }
    @Step("checkNoElementsOfSearchResult")
    public void checkBackButtonIsNotPresent() {
        this.waitForElementNotPresent(backButton, "Element should not be presented", 10);
    }
    @Step("waitForElementByTitleAndDescription")
    public SearchPageObject waitForElementByTitleAndDescription(String title, String description) {
        this.waitForElementIsPresent(getResultSearchResultElement(title, description),
                "Can not find Search result by title and description", 15);
        return this;
    }

}
