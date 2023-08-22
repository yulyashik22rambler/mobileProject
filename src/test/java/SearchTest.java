import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ui.CoreTestCase;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;
@Epic("SearchTest")
public class SearchTest extends CoreTestCase {

    @Test
    @Feature("search")
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
    @Feature("search")
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
    @Feature("search")
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