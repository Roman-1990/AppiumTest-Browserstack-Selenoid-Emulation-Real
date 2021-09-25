package tests.device;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("Web")
@Owner("roman")
@Feature("Issues")
public class WikiTests extends DeviceTestBase {

    @Test
    @JiraIssues({@JiraIssue("RK-03")})
    @Tag("device")
    @DisplayName("Checking the search")
    public void testSearch() {
        back();
        step("Проверяем поиск", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            step("Вводим данные в  строку поиска", () ->
                    $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Github")
            );
        });
        step("Проверка найденных данных", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @JiraIssues({@JiraIssue("RK-04")})
    @Tag("device")
    @DisplayName("Checking the start page")
    void verifyText() {
        step("Проверьте текст Энциклопедии", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The free Encyclopedia"));
            step("Нажимаем Продолжить", () ->
                    $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
            step("Проверка текста New ways to explore", () ->
                    $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                            .shouldHave(Condition.text("New ways to explore")));
        });
    }

    @Test
    @JiraIssues({@JiraIssue("RK-05")})
    @Tag("device")
    @DisplayName("Reading lists with sync")
    void readingTest() {
        step("Reading lists with sync", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Join Wikipedia"));
            step("Reading lists with sync", () ->
                    $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click()
            );
            $(MobileBy.id("org.wikipedia.alpha:id/switchView"))
                    .shouldHave(text("OFF"));

        });
    }

    @Test
    @JiraIssues({@JiraIssue("RK-06")})
    @Tag("device")
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
