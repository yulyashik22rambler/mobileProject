package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    private static String stepLearnMoreLink = "Learn more about Wikipedia";
    private static String stepNewWayToExplore = "New way to explore";
    private static String stepAddOrEditPreferredLanguages = "Add or edit preferred languages";
    private static String stepLearnMoreAboutDataCollected = "Learn more about data collected";
    private static String nextButton = "Next";
    private static String getStartedButton = "Get started";

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {

        this.waitForElementIsPresent(By.id(stepLearnMoreLink),
                "Cannot find 'Learn more about Wikipedia' element", 10);
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementIsPresent(By.id(stepNewWayToExplore),
                "Cannot find 'New way to explore' element", 10);
    }

    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementIsPresent(By.id(stepAddOrEditPreferredLanguages),
                "Cannot find 'Add or edit preferred languages' element", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementIsPresent(By.id(stepLearnMoreAboutDataCollected),
                "Cannot find 'Learn more about data collected' element", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(By.id(nextButton),
                "Cannot find and click 'Next' button", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(By.id(getStartedButton),
                "Cannot find and click 'Get started' button", 10);
    }
}
