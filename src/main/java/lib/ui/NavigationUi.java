package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUi extends MainPageObject {
    protected static String openNavigation, viewWatchList;

    public NavigationUi(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickMyList() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIos()) {
            this.tryClickElementWithFewAttempts(viewWatchList, "Can not find View list", 10);
        }
    }

    public void openNavigation() {
        if (Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(openNavigation, "Can not click on openNavigation button", 10);
            this.tryClickElementWithFewAttempts(viewWatchList, "Can not find View list", 10);
        } else {
            System.out.println("Method does not work for Android and IOS platform");
        }

    }


}
