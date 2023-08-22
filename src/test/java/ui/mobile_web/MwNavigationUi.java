package ui.mobile_web;

import ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwNavigationUi extends NavigationUi {
    static {
        openNavigation = "xpath:.//nav[@class='navigation-drawer toggle-list view-border-box']";
        viewWatchList = "xpath:.//a/span[contains(text(),'Watchlist')]";
    }

    public MwNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
