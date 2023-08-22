package ui.factories;

import ui.Platform;
import ui.ArticlePageObject;
import ui.IOS.IOSArticlePageObject;
import ui.android.AndroidArticlePageObject;
import ui.mobile_web.MwArticlePageObject;
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
