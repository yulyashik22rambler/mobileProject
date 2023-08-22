import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import ui.CoreTestCase;
import ui.Platform;
import ui.ArticlePageObject;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    @DisplayName("Switch Back ground mode test")
    @Description("Switch Back ground mode test")
    public void testArticleNavigateTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);

        this.switchBackGroundMode(2);
        ArticlePageObject articlePageObject1 = ArticlePageObjectFactory.get(driver);
        String articleTitle1 = articlePageObject1.getArticleTitle("Java");
        Assert.    assertEquals("We see unexpected title", "Java (programming language)", articleTitle1);
    }

    @Test
    @DisplayName("Rotate test")
    @Description("Check all is corrects after rotate")
    public void testRotateTest() {
        if (Platform.getInstance().isMw()) {
            return;
        }
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Maradona")
                .clickByArticleBySubstring("2018 film");
        ArticlePageObject articlePageObject1 = ArticlePageObjectFactory.get(driver);
        String articleTitle1 = articlePageObject1.getArticleTitle("2018 film");
        Assert.  assertEquals("We see unexpected title", "Maradona (2018 film)", articleTitle1);
        this.rotateScreen();
        String articleTitle2 = articlePageObject1.getArticleTitle("2018 film");
        Assert. assertEquals(articleTitle1, articleTitle2);
        this.rotateScreen();

    }
}
