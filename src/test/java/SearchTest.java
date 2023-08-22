import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ui.CoreTestCase;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;

public class SearchTest extends CoreTestCase {

    @Test
    @DisplayName("Search testS")
    @Description("Simple search test")
    public void testSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .waitForSearchResult("Object-oriented programming language");
    }

    @Test
    @DisplayName("Search cancel test")
    @Description("Search cancel test")
    public void testCancelSearchTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .waitForCancelButtonAppear()
                .clickBackButton()
                .waitForCancelButtonDisappear();
    }

    @Test
    @DisplayName("Put text and clear test")
    @Description("Put text and clear test")
    public void testPutTextAndClearTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clearSearchInput()
                .clickBackButton()
                .checkBackButtonIsNotPresent();
    }
}