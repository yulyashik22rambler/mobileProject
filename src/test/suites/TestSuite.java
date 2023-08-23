import lib.ui.WelcomePageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArticleTests.class,
        ChangeAppConditionTests.class,
        MyListTests.class,
        SearchTest.class,
        Ex5DeleteSavedSecondArticleTest.class
})
public class TestSuite {
}
