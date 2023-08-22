package ui;

import ui.factories.ArticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static String stepLearnMoreLink = "id:Learn more about Wikipedia";
    private static String stepNewWayToExplore = "id:New way to explore";
    private static String stepAddOrEditPreferredLanguages = "id:Add or edit preferred languages";
    private static String stepLearnMoreAboutDataCollected = "id:Learn more about data collected";
    private static String nextButton = "id:Next";
    private static String getStartedButton = "id:Get started";

    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {

        this.waitForElementIsPresent(stepLearnMoreLink, "Cannot find 'Learn more about Wikipedia' element", 10);
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementIsPresent(stepNewWayToExplore, "Cannot find 'New way to explore' element", 10);
    }

    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementIsPresent(stepAddOrEditPreferredLanguages, "Cannot find 'Add or edit preferred languages' element", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementIsPresent(stepLearnMoreAboutDataCollected, "Cannot find 'Learn more about data collected' element", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(nextButton, "Cannot find and click 'Next' button", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(getStartedButton, "Cannot find and click 'Get started' button", 10);
    }

    public static class ArticleTests extends CoreTestCase {
        @Test
        public void testCompareArticleTitleTest() {
            SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
            searchPageObject
                    .clickSkipButton()
                    .initSearchInput()
                    .typeSearchLineAndSendKey("Java")
                    .clickByArticleBySubstring("Object-oriented programming language");
            ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
            ;
            String articleTitle = articlePageObject.getArticleTitle("Java");
            Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
        }

        @Test
        public void testSwipeJavaArticleTest() {
            SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
            searchPageObject.clickSkipButton()
                    .initSearchInput()
                    .typeSearchLineAndSendKey("Java")
                    .clickByArticleBySubstring("Object-oriented programming language");
            ArticlePageObject articlePageObject1 = ArticlePageObjectFactory.get(driver);
            ;
            String articleTitle = articlePageObject1.getArticleTitle("Java");
            Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
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
            ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
            String articleTitle = articlePageObject.getArticleTitle("Java");
            Assert.assertEquals("We see unexpected title", "Java (programming language)", articleTitle);
            articlePageObject.swipeTillFooter();
        }


    }
}
