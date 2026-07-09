package ui.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import utils.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class ButtonsTest extends BaseTest {

    @BeforeEach
    void setUp() {
        openButtonsPage();
    }

    @Test
    void clickAllButtons() {
        doubleClickButton();
        verifyDoubleClickMessage();
        rightClickButton();
        verifyRightClickMessage();
        clickMeButton();
        verifyDynamicClickMessage();
    }

    @Step("Открываем страницу Buttons")
    void openButtonsPage() {
        openPage("https://demoqa.com/buttons");
    }

    @Step("Выполняем двойной клик по кнопке Double Click Me")
    void doubleClickButton() {
        $(Selectors.byId("doubleClickBtn")).doubleClick();
    }

    @Step("Проверяем сообщение о двойном клике")
    void verifyDoubleClickMessage() {
        $(Selectors.byId("doubleClickMessage"))
                .shouldHave(text("You have done a double click"));
    }

    @Step("Выполняем клик правой кнопкой мыши по кнопке Right Click Me")
    void rightClickButton() {
        $(Selectors.byId("rightClickBtn")).contextClick();
    }

    @Step("Проверяем сообщение о клике правой кнопкой мыши")
    void verifyRightClickMessage() {
        $(Selectors.byId("rightClickMessage"))
                .shouldHave(text("You have done a right click"));
    }

    @Step("Выполняем обычный клик по кнопке Click Me")
    void clickMeButton() {
        $(byText("Click Me")).click();
    }

    @Step("Проверяем сообщение о динамическом клике")
    void verifyDynamicClickMessage() {
        $(Selectors.byId("dynamicClickMessage"))
                .shouldHave(text("You have done a dynamic click"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
