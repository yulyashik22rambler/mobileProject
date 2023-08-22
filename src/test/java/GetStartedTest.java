import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import ui.CoreTestCase;
import ui.Platform;
import ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    @DisplayName("IOS test")
    @Description("IOS test")
    public void testPassThroughWelcome() {
        if (Platform.getInstance().isAndroid()||Platform.getInstance().isMw()) {
            return;
        }
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWayToExploreText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPreferredLangText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForLearnMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();
    }
}
