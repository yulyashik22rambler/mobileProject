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

    public void openNavigation() {
        if (Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(openNavigation, "Can not click on openNavigation button", 10);
            this.tryClickElementWithFewAttempts(viewList, "Can not find View list", 10);
        } else {
            System.out.println("Method does not work for Android and IOS platform");
        }

    }


}
