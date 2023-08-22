import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ui.CoreTestCase;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;

@Features
        (value = {@Feature("search"),
                @Feature("CheckThreeResultsByTitleAndDescrTest")})
public class Ex9CheckThreeResultsByTitleAndDescrTest extends CoreTestCase {
    @Test
    @DisplayName("testSearchAndCheckThreeResultsByTitleDescriptionTest")
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
