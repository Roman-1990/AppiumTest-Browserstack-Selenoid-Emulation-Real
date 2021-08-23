package tests.emulator;

import com.codeborne.selenide.Configuration;
import config.BrowserstackProject;
import config.EmulatorProject;
import drivers.EmulatorMobileDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class EmulatorTestBase {
    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = EmulatorMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addAttachments(EmulatorProject.emulatorConfig.driver());
        Configuration.browser = "drivers." + EmulatorProject.emulatorConfig.driver();

        closeWebDriver();
    }
}
