package test;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUi;
import lib.ui.SavedListPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.NavigationUiFactory;
import lib.ui.factories.SavedListPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListTests extends CoreTestCase {
    @Test
    public void testSaveFirstArticleToListTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title",
                "Java (programming language)", articleTitle);
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addToSaveList();
        } else {
            articlePageObject.addArticleToMySaved();
        }

        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        navigationUi.goToSavedList();

        SavedListPageObject savedListPageObject =  SavedListPageObjectFactory.get(driver);
        savedListPageObject.swipeToLeft("Java (programming language)");
        savedListPageObject.checkSavedArticlesCount("0 of 0 articles available offline");
    }
}
