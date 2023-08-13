package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.ArticleTests;
import test.ChangeAppConditionTests;
import test.MyListTests;
import test.SearchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArticleTests.class, ChangeAppConditionTests.class, MyListTests.class, SearchTest.class
})
public class TestSuite {
}
