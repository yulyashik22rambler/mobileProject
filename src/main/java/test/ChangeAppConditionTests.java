package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testArticleNavigateTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.clickSkipButton()
                .initSearchInput()
                .typeSearchLine("Java")
                .clickByArticleBySubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        String articleTitle = articlePageObject.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle);

        this.switchBackGroundMode(2);
        ArticlePageObject articlePageObject1 = new ArticlePageObject(driver);
        String articleTitle1 = articlePageObject1.getArticleTitle("Java");
        assertEquals("We see unexpected title", "Java (programming language)", articleTitle1);
    }

    @Test
    public void testRotateTest() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject
                .clickSkipButton()
                .initSearchInput()
                .typeSearchLine("Maradona")
                .clickByArticleBySubstring("2018 film");
        ArticlePageObject articlePageObject1 = new ArticlePageObject(driver);
        String articleTitle1 = articlePageObject1.getArticleTitle("2018 film");
        assertEquals("We see unexpected title", "Maradona (2018 film)", articleTitle1);
        this.rotateScreen();
        String articleTitle2 = articlePageObject1.getArticleTitle("2018 film");
        assertEquals(articleTitle1, articleTitle2);
        this.rotateScreen();

    }
}
