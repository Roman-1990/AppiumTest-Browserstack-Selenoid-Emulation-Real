package tests.selenoid;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("Web")
@Owner("roman")
@Feature("Issues")
public class SelenoidWikiTests extends SelenoidTestBase {

    @Test
    @JiraIssues({@JiraIssue("RK-01")})
    @Tag("selenoid")
    @DisplayName("Открытие и проверка Wiki")
    void searchTest() {
        step("Open wiki", () ->
                open("https://www.wikipedia.org/"));
        step("Options customization", () -> {
            $(byXpath("//*[@id='searchLanguage']")).click();
            $(byXpath("//*[@id='searchLanguage']/option[48]")).click();
            $(byXpath("//*[@id='jsLangLabel']")).shouldHave(text("ru"));
        });
        step("enter java", () -> {
            $("#searchInput").val("java").click();
            $$("#typeahead-suggestions").findBy(visible)
                    .shouldHave(text("язык программирования"));
            $$(".suggestion-link").first().click();
        });
        step("checking the text", () -> {
            $(".toctext").shouldHave(text("История создания"));
        });
    }
}
