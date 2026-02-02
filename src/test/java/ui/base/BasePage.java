package ui.base;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Базовый класс для всех страниц.
 * Содержит общие методы для работы с веб-элементами.
 */

public abstract class BasePage {
    // Логгер для записи действий на странице
    protected final Logger logger = LoggerFactory.getLogger(getClass());

     //Ввод текста в поле ввода
    protected void typeInto(By locator, String text){
        logger.info("Вводим '{}' в поле с элементом '{}'", text, locator);
        $(locator).shouldBe(visible).setValue(text);
    }

     //Клик по элементу
    protected void clickOn(By locator){
        logger.info("Кликаем на элемент '{}'", locator);
        $(locator).shouldBe(enabled).click();
    }

    //Ввод текста и закрытие выпадающего списка нажатием Enter
    //Используется для полей с автодополнением
    protected void typeIntoAndCloseDropdown(By locator, String text){
        logger.info("Вводим '{}' и закрываем выпадающий список", text);
        typeInto(locator, text);
        $(locator).pressEnter();
    }

     //Загрузка файла на страницу
    protected void uploadFile (By locator, String filePatch){
        logger.info("Загружаем файл '{}' в элемент '{}'", filePatch, locator);
        $(locator).uploadFromClasspath(filePatch);
    }

    //Выбор опции из выпадающего списка
    protected void selectFromDropdown(By locator, String optionText){
        logger.info("Выбираем '{}' из выпадающего списка '{}'", optionText, locator);
        clickOn(locator);
        $(byText(optionText)).click();
    }

    //Проверка видимости элемента на странице
    protected void verifyElementVisible(By locator) {
        logger.info("Проверяем что элемент '{}' видим", locator);
        $(locator).shouldBe(visible);
    }
}
