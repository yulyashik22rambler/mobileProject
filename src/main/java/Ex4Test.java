import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex4Test extends CoreTestCase {
    @Test
    public void testEx4CheckWordInSearchResultsTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .checkElementsOfSearchResultArePresent()
                .elementsInSearchResultHaveText("Java");
    }
}
