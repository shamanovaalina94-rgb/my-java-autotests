package utils;

import org.openqa.selenium.By;

/**
 * Вспомогательный класс для создания локаторов в удобном формате.
 * Упрощает работу с CSS-селекторами.
 */
public class Selectors {

    /**
     * Создает локатор по ID элемента.
     * Пример: byId("firstName") вернет By.cssSelector("#firstName")
     */
    public static By byId(String id){
        return By.cssSelector("#" + id);
    }

    /**
     * Создает локатор по атрибуту "for".
     * Используется для элементов label, связанных с input.
     */
    public static By byForAttribute(String forAttribute){
        return By.cssSelector("[for=" + forAttribute + "]");
    }
}
