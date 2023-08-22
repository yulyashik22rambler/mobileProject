package ui.factories;

import ui.Platform;
import ui.AuthorisationPageObject;
import ui.mobile_web.MwAuthorisationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthWikiPageObjectFactory {

    public static AuthorisationPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new MwAuthorisationPageObject(driver);
        } else{
            return new MwAuthorisationPageObject(driver);
        }
    }
}
