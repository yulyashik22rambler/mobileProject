import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ui.*;
import ui.factories.*;
@Feature("MyListTests")

public class MyListTests extends CoreTestCase {
    @Test
    @Feature("save")
    @DisplayName("testSaveFirstArticleToListTest")
    @Description("Remove first article")
    public void testSaveFirstArticleToListTest() {
        String email = "sacod90384@royalka.com";
        String login = "Koshka-Zaya";
        String password = "xzhBRNM8XUQy5m3";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);

        articlePageObject.addToSaveList();
        if (Platform.getInstance().isMw()) {
            AuthorisationPageObject authorisationPageObject = AuthWikiPageObjectFactory.get(driver);
            authorisationPageObject
                    .clickAuthButton()
                    .enterLoginData(login, password)
                    .submitButton();
            articlePageObject.getArticleTitle("Java");
            Assert.   assertEquals("We see unexpected title", "Java (programming language)", articlePageObject.getArticleTitle("Java"));
        }
        //Remove from list
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
