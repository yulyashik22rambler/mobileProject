package lib.ui.IOS;

import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUi extends NavigationUi {
    static {
        viewWatchList = "xpath://*[contains(@text,'View list')]";
    }

    public IOSNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
