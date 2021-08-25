package tests.selenoid;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SelenoidWikiTests extends SelenoidTestBase {

    @Test
    @Tag("selenoid")
    void searchTest() {
        open("https://www.wikipedia.org/");
        $(byXpath("//*[@id='searchLanguage']")).click();
        $(byXpath("//*[@id='searchLanguage']/option[48]")).click();
        $(byXpath("//*[@id='jsLangLabel']")).shouldHave(text("ru"));
        $("#searchInput").val("java").click();
        $$("#typeahead-suggestions").findBy(visible)
                .shouldHave(text("язык программирования"));
        $$(".suggestion-link").first().click();
        $(".toctext").shouldHave(text("История создания"));
    }
}
