package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorisationPageObject extends MainPageObject {
    public static String loginButton, loginInput, passwordInput, submitButton;

    public AuthorisationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public AuthorisationPageObject clickAuthButton() {
        sleep(1000);
        this.waitForElementIsPresent(loginButton, "Can not find and click login button", 20);
        this.waitForElementAndClick(loginButton, "Can not find and click login button", 2);
        return this;
    }

    public AuthorisationPageObject enterLoginData(String login, String password) {
        this.waitForElementAndSendKey(loginInput, login, "Can not click and send login", 5);
        this.waitForElementAndSendKey(passwordInput, password, "Can not click and send password", 5);
        return this;
    }

    public void submitButton() {
        this.waitForElementIsPresent(submitButton, "Can not find submit button", 5);
        this.waitForElementAndClick(submitButton, "Can not find and click on submit button", 5);
    }
}
