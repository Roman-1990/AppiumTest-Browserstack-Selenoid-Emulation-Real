package drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static config.Project.deviceConfig;


public class SelenoidMobileDriver implements WebDriverProvider {


    public static void configure() {

        Configuration.browserVersion = deviceConfig.browserVersion();
        Configuration.browser = deviceConfig.browser();
        Configuration.browserSize = deviceConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.remote = String.format(
                deviceConfig.selenoidUrl(),
                deviceConfig.selenoidUsername(),
                deviceConfig.selenoidPassword());

        Configuration.browserCapabilities = capabilities;
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        return null;
    }
}
