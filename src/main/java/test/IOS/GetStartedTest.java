package test.IOS;

import lib.ISOTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends ISOTestCase {
    @Test
    public void testPassThroughWelcome(){
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
