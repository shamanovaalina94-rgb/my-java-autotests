package api.tests;
import api.base.BaseApiTest;
import api.steps.UserApiSteps;
import com.github.javafaker.Faker;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import api.models.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class UserApiTest extends BaseApiTest {
  private final UserApiSteps userApiSteps = new UserApiSteps();

  private String createUserName;

  @Test
  void testCreateUser() {
    Faker faker = new Faker();
    // 1. Создаем пользователя
    User user = new User(
            faker.number().numberBetween(1, 100000),
            "AlinaName",
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            faker.phoneNumber().phoneNumber(),
            1);
    // 2. Отправляем на сервер
    createUserName = user.getUsername(); // Сохраняем имя созданного пользователя для последующих проверок
    var response = userApiSteps.createUser(user);// 1. Отправляем POST-запрос на создание пользователя
    // 3. Проверяем что создалось
    response.then()
            .statusCode(200)
            .body("code", equalTo(200));
    // 4. Проверяем что можем получить
    userApiSteps.getUserByName(createUserName)
            .then()
            .statusCode(200)
            .body("username", equalTo(createUserName))
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user.json"));// Сравниваем структуру ответа с JSON-схемой user.json
    //5. ОБНОВЛЯЕМ ПОЛЬЗОВАТЕЛЯ
    String updatedUserName = "AlinaNameUpdate";
    User updatedUser = new User(
            user.getId(),// сохраняем тот же id
            updatedUserName,
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            faker.phoneNumber().phoneNumber(),
            2);
    // 6. Отправляем обновление
    userApiSteps.updateUser(createUserName, updatedUser) //createUserName - сначала указываем имя, а затем в теле меняем значение всех полей кроме id - updatedUser
            .then()
            .statusCode(200)
            .body("code", equalTo(200));
    // 6. УДАЛЯЕМ пользователя
    userApiSteps.deleteUser(updatedUserName)// теперь указываем новое имя
            .then()
            .statusCode(200);
    // 7. Проверяем что удалился
    userApiSteps.getUserByName(updatedUserName)
            .then()
            .statusCode(404);
  }

  @Test
  void testCreateUsersList() {
    Faker faker = new Faker();
    List<User> userList = new ArrayList<>();
    //Создаем список пользователей
    userList.add(new User(faker.number().numberBetween(1, 1000),
            faker.name().name(),
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            faker.phoneNumber().phoneNumber(),
            1));
    userList.add(new User(faker.number().numberBetween(1001, 2000),
            faker.name().name(),
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            faker.phoneNumber().phoneNumber(),
            0));
    userList.add(new User(faker.number().numberBetween(2001, 3000),
            faker.name().name(),
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            faker.phoneNumber().phoneNumber(),
            2));

    var response = userApiSteps.createUsersList(userList); //отправляем post запрос
    response.then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("message", equalTo("ok"));
//Делаем get запрос для каждого пользователя
    for (User user : userList) {
      userApiSteps.getUserByName(user.getUsername())
              .then().statusCode(200)
              .body("username", equalTo(user.getUsername()))
              .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user.json"));
    }
    //Удаляем каждого пользователя из списка
    for (User user : userList) {
      userApiSteps.deleteUser(user.getUsername())
              .then().statusCode(200);
    }
    //Проверяем что все пользователи удалились
    for (User user : userList) {
      userApiSteps.getUserByName(user.getUsername())
              .then().statusCode(404);
    }
  }
}
