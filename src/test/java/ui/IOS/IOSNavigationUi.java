package ui.IOS;

import ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUi extends NavigationUi {
    static {
        NavigationUi.viewWatchList = "xpath://*[contains(@text,'View list')]";
    }

    public IOSNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
