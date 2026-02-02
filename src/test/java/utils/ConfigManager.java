package utils;
import java.io.IOException;
import java.util.Properties;
/**
 * Менеджер конфигурации для загрузки настроек из properties-файлов.
 * Используется для централизованного управления настройками тестового фреймворка.
 */
public class ConfigManager {
    private static final Properties properties = new Properties();
    // Статический блок инициализации - выполняется один раз при загрузке класса
    static {
        try {
            properties.load  // Загружаем все пары "ключ=значение" из файла config.properties
                    (ConfigManager.class.getClassLoader() // Получаем доступ к ресурсам проекта
                    .getResourceAsStream("config.properties"));  //Указываем данные какого класса нам нужны
        } catch (IOException e){ //Если файл не найден или ошибка чтения - выкидываем исключение
            throw new RuntimeException("Не удалось загрузить файл конфига", e);
        }
    }
    /**
     * Получение значения параметра по ключу.
     * Например: ConfigManager.get("baseUrl") вернет "https://petstore.swagger.io"
     */
    public static String get(String key){
        return properties.getProperty(key);
    }
}
