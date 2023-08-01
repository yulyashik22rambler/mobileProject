import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex9CheckResultsByTitleAndDescrTest extends CoreTestCase {
    @Test
    public void testSearchAndCheckThreeResultsByTitleDescriptionTest() {

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .waitForElementByTitleAndDescription("Java", "Island in Indonesia")
                .waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language")
                .waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
    }

}
