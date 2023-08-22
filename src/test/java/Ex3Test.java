import ui.CoreTestCase;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex3Test extends CoreTestCase {
    @Test
    public void testEx3SearchAndCancelTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .checkElementsOfSearchResultArePresent()
                .clearSearchInput()
                .checkNoElementsOfSearchResult();
    }
}
