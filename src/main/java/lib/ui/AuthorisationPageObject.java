package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorisationPageObject extends MainPageObject {
    public static String loginButton, loginInput, passwordInput, submitButton;

    public AuthorisationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    public AuthorisationPageObject clickAuthButton(){

        this.waitForElementIsPresent(loginButton,"Can not find login button",20);
        this.waitForElementAndClick(loginButton,"Can not find and click login button",20);
        return this;
    }
    public AuthorisationPageObject enterLoginData(String login, String password)    {
        this.waitForElementAndSendKey(loginInput,login,"Can not click and send login",10);
        this.waitForElementAndSendKey(passwordInput,password,"Can not click and send password",10);
        return this;
    }
    public void submitButton(){
        this.waitForElementIsPresent(submitButton,"Can not find submit button",10);
        this.waitForElementAndClick(submitButton,"Can not find and click on submit button",10);
    }
}
