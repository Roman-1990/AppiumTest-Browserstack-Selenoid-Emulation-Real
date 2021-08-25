package tests.selenoid;


import com.codeborne.selenide.Configuration;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.Project.deviceConfig;


public class SelenoidTestBase {
    @BeforeAll
    public static void setup() {
        addListener("AllureAttachments", new AllureSelenide());
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

    @BeforeEach
    public void startSelenoidDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addAttachments(deviceConfig.driver());
        Configuration.browser = "drivers." + deviceConfig.driver();
    }
}
