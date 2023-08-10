package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitleTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject =  ArticlePageObjectFactory.get(driver);;
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
    }

    @Test
    public void testSwipeJavaArticleTest() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject1 =  ArticlePageObjectFactory.get(driver);;
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
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLineAndSendKey("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject =  ArticlePageObjectFactory.get(driver);;
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        articlePageObject.swipeTillFooter();
    }


}
