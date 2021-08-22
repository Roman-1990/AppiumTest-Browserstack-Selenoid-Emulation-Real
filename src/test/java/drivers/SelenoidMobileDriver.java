package drivers;

import com.codeborne.selenide.Configuration;
import config.SelenoidProject;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SelenoidMobileDriver {


    public static void configure() {
        Configuration.browserVersion = SelenoidProject.selenoidConfig.browserVersion();
        Configuration.browser = SelenoidProject.selenoidConfig.browser();
        Configuration.browserSize = SelenoidProject.selenoidConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.remote = String.format(
                SelenoidProject.selenoidConfig.selenoidUrl(),
                SelenoidProject.selenoidConfig.selenoidUsername(),
                SelenoidProject.selenoidConfig.selenoidPassword());

        Configuration.browserCapabilities = capabilities;
    }

}
