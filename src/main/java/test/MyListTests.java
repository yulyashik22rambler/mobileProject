package test;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

public class MyListTests extends CoreTestCase {

    String email = "//sacod90384@royalka.com";
    String login = "Koshka-Zaya";
    String password = "xzhBRNM8XUQy5m3";

    @Test
    public void testSaveFirstArticleToListTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addToSaveList();
        } else if (Platform.getInstance().isIos()) {
            articlePageObject.addArticleToMySaved();
        } else {
            articlePageObject.clickOnSaveButton();
            AuthorisationPageObject authorisationPageObject = AuthWikiPageObjectFactory.get(driver);
            authorisationPageObject
                    .clickAuthButton()
                    .enterLoginData(login, password)
                    .submitButton();
            articlePageObject.getArticleTitle("Java");
            assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        }
        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        navigationUi.openNavigation();
        navigationUi.clickMyList();

        SavedListPageObject savedListPageObject = SavedListPageObjectFactory.get(driver);
        savedListPageObject.removeBySwipeToLeftOrClick("Java (programming language)");
        navigationUi.openNavigation();
        if (Platform.getInstance().isMw()) {
            savedListPageObject.checkEmptySavedArticles("You are not currently watching any pages.");
        } else {
            savedListPageObject.checkSavedArticlesCount("0 of 0 articles available offline");
        }
    }
}
