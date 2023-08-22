package ui.android;

import ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUi extends NavigationUi {
    static {
        NavigationUi.viewWatchList = "xpath://*[contains(@text,'View list')]";
    }

    public AndroidNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
