package ui;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String platformAndroid = "android";
    private static final String platformIOS = "ios";
    private static final String platformMobileWeb = "mobile_web";
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

    public RemoteWebDriver getDriver() throws Exception {
        URL url = new URL(appiumUrl);
        if (isAndroid()) {
            return new AndroidDriver(url, this.getAndroidDesiredCapabilities());
        } else if (isIos()) {
            return new IOSDriver(url, this.getIOSDesiredCapabilities());
        } else if (isMw()) {
            return new ChromeDriver(this.getMbChromeOptions());
        } else {
            throw new Exception("Can not detect driver" + this.getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return this.isPlatform(platformAndroid);
    }

    public boolean isIos() {
        return this.isPlatform(platformIOS);
    }

    public boolean isMw() {
        return this.isPlatform(platformMobileWeb);
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

    public String getPlatformVar() {
        String platform = System.getenv("PLATFORM");
        if (platform == null) {
            platform = "android";
        }
        return platform;
    }

    private boolean isPlatform(String myPlatform) {
        return myPlatform.equals(this.getPlatformVar());
    }

    private ChromeOptions getMbChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Chrome/18.0.1025.166 Mobile Safari/535.19");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=340,640");
        return chromeOptions;
    }
}
