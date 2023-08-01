package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUi  extends MainPageObject {
    public NavigationUi(AppiumDriver driver) {
        super(driver);
    }
    private   String viewListXpath = "//*[contains(@text,'View list')]";

    public void goToSavedList() {
        this.waitForElementAndClick(By.xpath(viewListXpath), "Can not find View list", 10);
    }
}
