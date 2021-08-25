package tests.selenoid;


import com.codeborne.selenide.Configuration;
import config.Project;
import drivers.SelenoidMobileDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


public class SelenoidTestBase {
    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        if (Objects.equals(Project.deviceConfig.driver(), "driver")) {
            SelenoidMobileDriver.configure();
        }
    }

    @BeforeEach
    public void startSelenoidDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addAttachments(Project.deviceConfig.driver());
        Configuration.browser = "drivers." + Project.deviceConfig.driver();
    }
}
