package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiTest extends BaseTest {

    @Test
    void googlePageTitleContainsGoogle() {
        openPage("https://www.google.com");
        assertTrue(title().contains("Google"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
