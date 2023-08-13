package lib.ui.android;

import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUi extends NavigationUi {
    static {
        viewList = "xpath://*[contains(@text,'View list')]";
    }

    public AndroidNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
