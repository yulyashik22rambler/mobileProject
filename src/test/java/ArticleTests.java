import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.CoreTestCase;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

@Epic("Tests for article")
@Feature("article")
public class ArticleTests extends CoreTestCase {
    @Test
    @DisplayName("Compare article title with expected one")
    @Description("Click by description 'Object-oriented programming language' and go read")
    @Feature("article")
    @Severity(value = SeverityLevel.CRITICAL)
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
    @Feature("search")
    @Severity(value = SeverityLevel.NORMAL)
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
    @Feature("search")
    @Severity(value = SeverityLevel.MINOR)
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