package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUi;
import lib.ui.SavedListPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListTests extends CoreTestCase {
    @Test
    public void testArticleSaveToListTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title",
                "Java (programming language)", articleTitle);
        articlePageObject.addToSaveList();
        NavigationUi navigationUi = new NavigationUi(driver);
        navigationUi.goToSavedList();
        SavedListPageObject savedListPageObject = new SavedListPageObject(driver);
        savedListPageObject.swipeToLeft("Java (programming language)");
        savedListPageObject.checkSavedArticlesCount("0 of 0 articles available offline");
    }
}
