import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import ui.CoreTestCase;
import ui.ArticlePageObject;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    @DisplayName("Compare article title with expected one")
    @Description("Click by description 'Object-oriented programming language' and go read")
    public void testCompareArticleTitleTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
    }

    @Test
    @DisplayName("Swipe article down")
    @Description("Search Java article and swipe down")
    public void testSwipeJavaArticleTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject1.getArticleTitle("Java");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject1.swipe()
                .swipe()
                .swipe()
                .swipe()
                .swipe();
    }

    @Test
    @DisplayName("Swipe article to the footer")
    @Description("Search Java article and swipe till footer of the site")
    public void testSwipeTillFooterTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject.swipeTillFooter();
    }
}