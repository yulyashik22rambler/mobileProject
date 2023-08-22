package ui.mobile_web;

import ui.AuthorisationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwAuthorisationPageObject extends AuthorisationPageObject {
    static {
        AuthorisationPageObject.loginButton = "xpath:.//a[@type='button'][./*[text()='Log in']]";
        AuthorisationPageObject.loginInput = "xpath:.//input[contains(@id,'wpName1')]";
        AuthorisationPageObject.passwordInput = "xpath:.//input[contains(@id,'wpPassword1')]";
        AuthorisationPageObject.submitButton = "xpath:.//button[contains(@id,'wpLoginAttempt')]";
    }

    public MwAuthorisationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
