package api.steps;
import api.base.BaseApiTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.models.User;
import java.util.List;

public class UserApiSteps extends BaseApiTest {

    @Step("Создаем пользователя")
    public Response createUser (User user){
        logger.info("Отправляем POST запрос на /v2/user для пользователя '{}'", user.getUsername());
        return requestSpecification()
                .body(user)
                .post("/v2/user");
    }
    @Step("Получаем пользователя по имени {username}")
    public Response getUserByName(String username) { //username - тк в сваггере нужно ввсети только имя без тела
        logger.info("Отправляем GET запрос на /v2/user/{}", username);
        return requestSpecification()
                .get("/v2/user/" + username);
    }
    @Step("Обновляем пользователя {username}")
    public Response updateUser(String username, User user){ // username - тк нам нужно сначала ввести имя в сваггере, а только потом тело - user
        logger.info("Отправляем PUT запрос на /v2/user/{}", username);
        return requestSpecification()
                .body(user)
                .put("/v2/user/" + username);
    }
    @Step("Удаляем пользователя {username}")
    public Response deleteUser(String username) { //username - тк в сваггере нужно ввсети только имя без тела
        logger.info("Отправляем DELETE запрос на /v2/user/{}", username);
        return requestSpecification()
                .delete("/v2/user/" + username);
    }
    @Step("Создаем список пользователей")
    public Response createUsersList(List<User> users) {
        logger.info("Отправляем POST запрос на /v2/user/createWithList для списка из {} пользователей", users.size());
        return requestSpecification()
                .body(users)
                .post("/v2/user/createWithList");
    }
}
