import lib.ui.WelcomePageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WelcomePageObject.ArticleTests.class, ChangeAppConditionTests.class, MyListTests.class, SearchTest.class
})
public class TestSuite {
}
