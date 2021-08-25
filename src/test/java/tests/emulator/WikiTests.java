package tests.emulator;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class WikiTests extends EmulatorTestBase {

    @Test
    @Tag("emulator")
    @DisplayName("Checking the search")
    public void sampleTest() {
        back();
        step("Проверяем поиск", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Github");
        });
        step("Проверка найденных данных", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("emulator")
    @DisplayName("Checking the start page")
    void verifyText() {
        step("Проверьте текст Энциклопедии", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The free Encyclopedia"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
    }

    @Test
    @Tag("emulator")
    @DisplayName("New ways to explore")
    void exploreTest() {
        step("New ways to explore", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
    }

    @Test
    @Tag("emulator")
    @DisplayName("Reading lists with sync")
    void readingTest() {
        step("Reading lists with sync", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Join Wikipedia"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
    }

    @Test
    @Tag("emulator")
    @DisplayName("Send anonymous data. Checkbox check")
    void checkboxTest() {
        step("Send anonymous data. Checkbox check", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/switchView"))
                    .shouldHave(text("ON")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/switchView"))
                    .shouldHave(text("OFF"));
        });
    }
}
