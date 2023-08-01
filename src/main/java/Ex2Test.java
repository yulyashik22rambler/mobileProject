import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex2Test extends CoreTestCase {
    @Test
    public void testSearchFieldContainsTextTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLine("Search smth")
                .assertSearchInputHasText("Search smth");
    }
}
