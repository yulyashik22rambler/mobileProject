import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex4Test extends CoreTestCase {
    @Test
    public void testEx4CheckWordInSearchResultsTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .checkElementsOfSearchResultArePresent()
                .elementsInSearchResultHaveText("Java");
    }
}
