import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUi;
import lib.ui.SavedListPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex5DeleteSavedSecondArticleTest extends CoreTestCase {
    @Test
    public void testDeleteSavedSecondArticleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 = new ArticlePageObject(driver);
        String articleTitle = articlePageObject1.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject1.addToSaveList();

        //Kotlin статья
        SearchPageObject searchPageObject2 = new SearchPageObject(driver);
        searchPageObject2
                .initSearchInput()
                .typeSearchLineAndSendKey("Kotlin")
                .clickByArticleBySubstring("General-purpose programming language derived from Java");
        ArticlePageObject articlePageObject2 = new ArticlePageObject(driver);
        String articleTitle2 = articlePageObject2.getArticleTitle("Kotlin");
        assertEquals("We see unexpected title", "Kotlin (programming language)", articleTitle2);
        articlePageObject2.addToSaveList();

        //2. Удаляет одну из статей
        NavigationUi navigationUi = new NavigationUi(driver);
        navigationUi.goToSavedList();
        SavedListPageObject savedListPageObject = new SavedListPageObject(driver);
        savedListPageObject.swipeToLeft("Java (programming language)");

        //3. Убеждается, что вторая осталась
        savedListPageObject.checkSavedArticleTitleIsPresent("Kotlin (programming language)");
        savedListPageObject.checkSavedArticlesCount("1 of 1 article available offline");

        //4. Переходит в неё и убеждается, что title совпадает
        ArticlePageObject articlePageObject3 = savedListPageObject.goToArticlePageClickByTitle("Kotlin (programming language)");
        assertEquals("We see unexpected title", "Kotlin (programming language)", articlePageObject3.getArticleTitle("Kotlin"));
    }
}
