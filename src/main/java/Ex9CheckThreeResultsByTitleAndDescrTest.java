import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex9CheckThreeResultsByTitleAndDescrTest extends CoreTestCase {
    @Test
    public void testSearchAndCheckThreeResultsByTitleDescriptionTest() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .waitForElementByTitleAndDescription("Java", "Island in Indonesia")
                .waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language")
                .waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
    }

}
