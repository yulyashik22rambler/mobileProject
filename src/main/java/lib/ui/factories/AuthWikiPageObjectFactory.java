package lib.ui.factories;

import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.AuthorisationPageObject;
import lib.ui.IOS.IOSArticlePageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.mobile_web.MwArticlePageObject;
import lib.ui.mobile_web.MwAuthorisationPageObject;
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
