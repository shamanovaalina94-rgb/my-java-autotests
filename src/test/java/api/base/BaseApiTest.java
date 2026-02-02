package api.base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigManager;
import static io.restassured.RestAssured.given;

/**
 * Базовый класс для всех API-тестов.
 * Предоставляет общую конфигурацию и вспомогательные методы для работы с HTTP-запросами.
 */

public abstract class BaseApiTest {
    // Логгер для записи информации о выполнении тестов
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    // Статический блок выполняется один раз при загрузке класса
    static {
        // Базовый URL для всех HTTP-запросов
        // Значение берется из конфигурационного файла через ConfigManager
        RestAssured.baseURI = ConfigManager.get("baseUrl");
        // Включаем детальное логирование при падении тестов
        // Если проверка (then()) не пройдет, в консоли увидим:
        // - Что мы отправили (запрос)
        // - Что нам пришло (ответ)
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /**
     * HTTP-запрос с настройками по умолчанию.
     * Все запросы в тестах будут использовать JSON формат.
     */

    protected RequestSpecification requestSpecification(){
        return given()  // Создаем базовый запрос
                .contentType(ContentType.JSON) //Отправляются данные в формате json
                .accept(ContentType.JSON); //Принимаются данные в формате json
    }
}
