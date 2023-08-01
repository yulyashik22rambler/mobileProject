package test;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTest extends CoreTestCase {

    @Test
    public void testSearch() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearchTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .waitForCancelButtonAppear()
                .clickBackButton()
                .waitForCancelButtonDisappear();
    }

    @Test
    public void testPutTextAndClearTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clearSearchInput()
                .clickBackButton()
                .checkBackButtonIsNotPresent();
    }
}