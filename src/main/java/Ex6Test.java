import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex6Test extends CoreTestCase {
    @Test
    public void testCheckArticleTitleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLine("Maradona")
                .clickByArticleBySubstring("2018 film");
        ArticlePageObject articlePageObject1 = new ArticlePageObject(driver);
        String articleTitle1 = articlePageObject1.getArticleTitle("2018 film");
        assertEquals("We see unexpected title", "Maradona (2018 film)", articleTitle1);
    }
}
