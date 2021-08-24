package drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static config.SelenoidProject.selenoidConfig;


public class SelenoidMobileDriver implements WebDriverProvider{


    public static void configure() {

        Configuration.browserVersion = selenoidConfig.browserVersion();
        Configuration.browser = selenoidConfig.browser();
        Configuration.browserSize = selenoidConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.remote = String.format(
                selenoidConfig.selenoidUrl(),
                selenoidConfig.selenoidUsername(),
                selenoidConfig.selenoidPassword());

        Configuration.browserCapabilities = capabilities;
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        return null;
    }
}
