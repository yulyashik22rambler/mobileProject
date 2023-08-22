import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.Test;
import ui.*;
import ui.factories.*;

public class Ex5DeleteSavedSecondArticleTest extends CoreTestCase {
    @Test
    @Feature("save")
    public void testDeleteSavedSecondArticleTest() {
        String login = "Koshka-Zaya";
        String password = "xzhBRNM8XUQy5m3";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject1.getArticleTitle("Java");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject1.addToSaveList();
        if (Platform.getInstance().isMw()) {
            AuthorisationPageObject authorisationPageObject = AuthWikiPageObjectFactory.get(driver);
            authorisationPageObject
                    .clickAuthButton()
                    .enterLoginData(login, password)
                    .submitButton();
            Assert.assertEquals("We see unexpected title", "Java (programming language)", articlePageObject1.getArticleTitle("Java"));

        }
        //Kotlin статья
        SearchPageObject searchPageObject2 = SearchPageObjectFactory.get(driver);
        searchPageObject2
                .initSearchInputMb()
                .typeSearchLineAndSendKeyMb("Kotlin")
                .clickByArticleBySubstring("General-purpose programming language derived from Java");
        ArticlePageObject articlePageObject2 = ArticlePageObjectFactory.get(driver);
        String articleTitle2 = articlePageObject2.getArticleTitle("Kotlin");
        Assert.assertEquals("We see unexpected title", "Kotlin (programming language)", articleTitle2);
        articlePageObject2.addToSaveList();
        Assert.assertEquals("We see unexpected title", "Kotlin (programming language)", articleTitle2);

        //2. Удаляет одну из статей
        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        navigationUi.openNavigation();
        navigationUi.clickMyList();

        SavedListPageObject savedListPageObject = SavedListPageObjectFactory.get(driver);
        savedListPageObject.removeBySwipeToLeftOrClick("Java (programming language)");
        navigationUi.openNavigation();

        //3. Убеждается, что вторая осталась
        savedListPageObject.checkSavedArticleTitleIsPresent("Kotlin (programming language)");

        //4. Переходит в неё и убеждается, что title совпадает
        ArticlePageObject articlePageObject3 = savedListPageObject.goToArticlePageClickByTitle("Kotlin (programming language)");
        Assert.assertEquals("We see unexpected title", "Kotlin (programming language)", articlePageObject3.getArticleTitle("Kotlin"));
    }
}