package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static config.EmulatorProject.emulatorConfig;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmulatorMobileDriver implements WebDriverProvider {


    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulatorConfig.getEmulatorUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("deviceName", emulatorConfig.getEmulatorDevice());
        desiredCapabilities.setCapability("version", emulatorConfig.getEmulatorOsVersion());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath(emulatorConfig.getEmulatorApp()));


        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
