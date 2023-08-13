package lib.ui.mobile_web;

import lib.ui.AuthorisationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwAuthorisationPageObject extends AuthorisationPageObject {
    static {
        loginButton = "xpath:.//a[@type='button'][./*[text()='Log in']]";
        loginInput = "xpath:.//input[contains(@id,'wpName1')]";
        passwordInput = "xpath:.//input[contains(@id,'wpPassword1')]";
        submitButton = "xpath:.//button[contains(@id,'wpLoginAttempt')]";
    }

    public MwAuthorisationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
