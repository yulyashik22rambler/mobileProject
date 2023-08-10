package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class Platform {
    private static final String platformAndroid = "android";
    private static final String platformIOS = "IOS";
    private static final String appiumUrl = "http://127.0.0.1:4723/wd/hub";
    private static Platform instance;

    private Platform() {
    }

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }


    public AppiumDriver getDriver() throws Exception {
        URL url = new URL(appiumUrl);
        if (isAndroid()) {
            return new AndroidDriver(url, this.getAndroidDesiredCapabilities());
        } else if (isIOS()) {
            return new IOSDriver(url, this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("Can not detect driver" + this.getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return this.isPlatform(platformAndroid);
    }

    public boolean isIOS() {
        return this.isPlatform(platformIOS);
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equals(platformAndroid)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apks/org.wikipedia.apk");
        } else {
            if (platform.equals(platformIOS)) {
                capabilities.setCapability("platformName", "IOS");
                capabilities.setCapability("deviceName", "iPhone SE");
                capabilities.setCapability("platformVersion", "11.3");
                capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apps/Wikipedia.app");
            } else {
                throw new Exception("Can not run platform from env");
            }
        }
        return capabilities;
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apks/org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("app", "/home/julia/WorkSpace/WS_2023/mobileTesting/apps/Wikipedia.app");
        return capabilities;
    }

    private String getPlatformVar() {
        return System.getenv("PLATFORM");
    }

    private boolean isPlatform(String myPlatform) {
        return myPlatform.equals(this.getPlatformVar());
    }
}
