import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex6Test extends CoreTestCase {
    @Test
    public void testCheckArticleTitleTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Maradona")
                .clickByArticleBySubstring("2018 film");
        ArticlePageObject articlePageObject1 =  ArticlePageObjectFactory.get(driver);
        String articleTitle1 = articlePageObject1.getArticleTitle("2018 film");
        assertEquals("We see unexpected title", "Maradona (2018 film)", articleTitle1);
    }
}
