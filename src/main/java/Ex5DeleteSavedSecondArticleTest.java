import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex5DeleteSavedSecondArticleTest extends CoreTestCase {
    @Test
    public void testDeleteSavedSecondArticleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLine("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 = new ArticlePageObject(driver);
        String articleTitle = articlePageObject1.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject1.addToSaveList();

        //Kotlin статья
        SearchPageObject searchPageObject2 = new SearchPageObject(driver);
        searchPageObject2
                .initSearchInput()
                .typeSearchLine("Kotlin")
                .clickByArticleBySubstring("General-purpose programming language derived from Java");
        ArticlePageObject articlePageObject2 = new ArticlePageObject(driver);
        String articleTitle2 = articlePageObject2.getArticleTitle("Kotlin");
        assertEquals("We see unexpected title", "Kotlin (programming language)", articleTitle2);
        articlePageObject2.addToSaveList();
    }
}
