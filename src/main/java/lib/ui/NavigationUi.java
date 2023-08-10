package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUi extends MainPageObject {
    protected static String viewList;

    public NavigationUi(AppiumDriver driver) {
        super(driver);
    }

    public void goToSavedList() {
        this.waitForElementAndClick(viewList, "Can not find View list", 10);
    }
}
