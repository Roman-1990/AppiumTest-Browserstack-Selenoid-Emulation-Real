package tests.selenoid;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Project.deviceConfig;


public class SelenoidTestBase {
    @BeforeAll
    public static void setup() {
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
}
