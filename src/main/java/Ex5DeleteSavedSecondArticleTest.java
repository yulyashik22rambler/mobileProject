import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUi;
import lib.ui.SavedListPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.NavigationUiFactory;
import lib.ui.factories.SavedListPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex5DeleteSavedSecondArticleTest extends CoreTestCase {
    @Test
    public void testDeleteSavedSecondArticleTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 =  ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject1.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject1.addToSaveList();

        //Kotlin статья
        SearchPageObject searchPageObject2 = SearchPageObjectFactory.get(driver);
        searchPageObject2
                .initSearchInput()
                .typeSearchLineAndSendKey("Kotlin")
                .clickByArticleBySubstring("General-purpose programming language derived from Java");
        ArticlePageObject articlePageObject2 =  ArticlePageObjectFactory.get(driver);
        String articleTitle2 = articlePageObject2.getArticleTitle("Kotlin");
        assertEquals("We see unexpected title", "Kotlin (programming language)", articleTitle2);
        articlePageObject2.addToSaveList();

        //2. Удаляет одну из статей
        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        navigationUi.goToSavedList();
        SavedListPageObject savedListPageObject =  SavedListPageObjectFactory.get(driver);
        savedListPageObject.swipeToLeft("Java (programming language)");

        //3. Убеждается, что вторая осталась
        savedListPageObject.checkSavedArticleTitleIsPresent("Kotlin (programming language)");
        savedListPageObject.checkSavedArticlesCount("1 of 1 article available offline");

        //4. Переходит в неё и убеждается, что title совпадает
        ArticlePageObject articlePageObject3 = savedListPageObject.goToArticlePageClickByTitle("Kotlin (programming language)");
        assertEquals("We see unexpected title", "Kotlin (programming language)", articlePageObject3.getArticleTitle("Kotlin"));
    }
}
