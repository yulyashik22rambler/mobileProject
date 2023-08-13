package lib.ui.factories;

import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.IOS.IOSArticlePageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.mobile_web.MwArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isIos()) {
            return new IOSArticlePageObject(driver);
        } else {
            return new MwArticlePageObject(driver);
        }
    }
}
