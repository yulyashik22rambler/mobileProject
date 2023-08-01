import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex3Test extends CoreTestCase {
    @Test
    public void testEx3SearchAndCancelTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .checkElementsOfSearchResultArePresent()
                .clearSearchInput()
                .checkNoElementsOfSearchResult();
    }
}
