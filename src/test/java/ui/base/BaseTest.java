package ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

/**
 * Базовый класс для всех UI-тестов.
 * Настраивает Selenide перед запуском тестов.
 */

public abstract class BaseTest {
    //Метод выполняется один раз перед всеми тестами
    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout =  60000; // Таймаут загрузки страницы (60 секунд из-за медленного сайта)
        Configuration.timeout = 30000;          // Таймаут ожидания элементов (30 секунд из-за медленного сайта)
        Configuration.headless = true;

        // Настройка Allure-отчетов для Selenide
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }
    //Открывает указанную страницу в браузере
    protected void openPage (String url){
        open(url);
    }
}

