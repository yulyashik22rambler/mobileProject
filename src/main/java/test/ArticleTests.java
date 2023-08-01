package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
    }

    @Test
    public void testSwipeJavaArticleTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 = new ArticlePageObject(driver);
        String articleTitle = articlePageObject1.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject1.swipe()
                .swipe()
                .swipe()
                .swipe()
                .swipe();
    }
    @Test
    public void testSwipeTillFooterTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Appium")
                .clickByArticleBySubstring("Automation for Apps");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        String articleTitle = articlePageObject.getArticleTitle("Appium");
        assertEquals("We see unexpected title", "Appium", articleTitle);
        articlePageObject.swipeTillFooter();
    }


}
