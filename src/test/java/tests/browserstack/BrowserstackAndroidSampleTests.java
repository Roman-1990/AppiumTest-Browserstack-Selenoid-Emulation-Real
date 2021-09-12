package tests.browserstack;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import com.codeborne.selenide.Configuration;
import config.Project;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("Web")
@Owner("roman")
@Feature("Issues")
public class BrowserstackAndroidSampleTests extends BrowserstackTestBase {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = Project.deviceConfig.apiUrl();
        Configuration.baseUrl = Project.deviceConfig.webUrl();
    }

    @Test
    @JiraIssues({@JiraIssue("RK-02")})
    @Tag("browserstack")
    @DisplayName("Check Login option at menu")
    void loginOptionCheck() {
        step("Wait while Wikipedia is opened", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).shouldBe(visible));
        step("Open menu", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click());
        step("Check Log in to Wikipedia option", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia")));
    }

    @Test
    @JiraIssues({@JiraIssue("RK-03")})
    @Tag("browserstack")
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));

    }
}
