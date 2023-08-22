import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import ui.CoreTestCase;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex2Test extends CoreTestCase {
    @Test
    @DisplayName("testSearchFieldContainsTextTest")
    @Description("testSearchFieldContainsTextTest")
    public void testSearchFieldContainsTextTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Search smth")
                .assertSearchInputHasText("Search smth");
    }
}
