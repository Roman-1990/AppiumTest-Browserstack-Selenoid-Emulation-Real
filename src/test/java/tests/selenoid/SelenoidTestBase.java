package tests.selenoid;


import com.codeborne.selenide.Configuration;
import config.SelenoidProject;
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
        if (Objects.equals(SelenoidProject.selenoidConfig.driver(), "SelenoidDriver")) {
            SelenoidMobileDriver.configure();
        }
    }

    @BeforeEach
    public void startSelenoidDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addAttachments(SelenoidProject.selenoidConfig.driver());
        Configuration.browser = "drivers." + SelenoidProject.selenoidConfig.driver();
    }
}
