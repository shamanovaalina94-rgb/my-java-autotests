package api.tests;

import api.base.BaseApiTest;
import api.steps.PetApiSteps;
import com.github.javafaker.Faker;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import api.models.Pet;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class PetApiTest extends BaseApiTest {

    private final PetApiSteps petApiSteps = new PetApiSteps();

    //  МЕТОД 1: Проверка основных полей через GET
    private void verifyBasicPetFields(int petId, String petName, String status) {
        petApiSteps.getPetById(petId)  // Шаг 1: GET запрос
                .then()               // Шаг 2: начинаем проверки
                .statusCode(200)   // Шаг 3: проверяем статус код
                .body("id", equalTo(petId))  // Шаг 4: проверяем ID
                .body("name", equalTo(petName))  // Шаг 5: проверяем имя
                .body("status", equalTo(status)); // Шаг 6: проверяем статус
    }

    // МЕТОД 2: Проверка основных полей в уже полученном ответе
    private void verifyPetInResponse(Response response,
                                     int expectedId,
                                     String expectedName,
                                     String expectedStatus) {
        response.then()                             // Шаг 1: Начинаем проверки ответа
                .statusCode(200)                    // Шаг 2: Проверяем статус код ответа
                .body("id", equalTo(expectedId))    // Шаг 3: Проверяем поле id в теле ответа
                .body("name", equalTo(expectedName)) // Шаг 4: Проверяем поле name в теле ответа
                .body("status", equalTo(expectedStatus)); // Шаг 5: Проверяем поле status в теле ответа
    }
    @Test
    void CreateFullPet(){
        Faker faker = new Faker();
        //Создаем категорию
        Pet.Category category = new Pet.Category(
                faker.number().numberBetween(1, 1000),
               "Dogs"
        );
        //Создаем список тегов
        List<Pet.Tag> tags = Arrays.asList(
                new Pet.Tag(1, "Braiton"),
                new Pet.Tag(2, "Molly"),
                new Pet.Tag(3, "Ruby")
        );
        //Создаем список фото
        List<String> photoUrls = Arrays.asList(
                "https://example.com/photo1.jpg",
                "https://example.com/photo2.jpg"
        );
        //Создаем полного питомца
        int petId = faker.number().numberBetween(1, 1000); //сохраняем id для следующих проверок
        String petName = "Rex";

        Pet pet = new Pet(
                petId,
                petName,
                photoUrls,
                "available",
                category,
                tags
        );
        //Отправляем POST запрос
        Response postResponse = petApiSteps.createPet(pet);
        verifyPetInResponse(postResponse, petId, petName, "available"); //Проверяем основные поля с помощью нового метода
        postResponse.then().statusCode(200) // Проверяем остальные поля в том же ответе
               //Массив фото
               .body("photoUrls[0]", equalTo("https://example.com/photo1.jpg"))// индекс 0 - первая ссылка
               .body("photoUrls[1]", equalTo("https://example.com/photo2.jpg"))
               .body("photoUrls", hasSize(2))// проверка на размер массива
               //Вложенный объект Категория
               .body("category.id", equalTo(category.getId()))
               .body("category.name", equalTo("Dogs"))
               //Массив объектов Теги
               .body("tags[0].id", equalTo(1))
               .body("tags[0].name", equalTo("Braiton"))
               .body("tags[1].id", equalTo(2))
               .body("tags[1].name", equalTo("Molly"))
               .body("tags[2].id", equalTo(3))
               .body("tags[2].name", equalTo("Ruby"))
               .body("tags", hasSize(3))
        // JSON Schema валидация
               .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("pet.json"));

       //Отправляем GET запрос - проверка создания
        verifyBasicPetFields(petId, petName, "available"); //проверяем основные поля в методе
        petApiSteps.getPetById(petId)
                .then().statusCode(200)
                .body("photoUrls[0]", equalTo("https://example.com/photo1.jpg"))// индекс 0 - первая ссылка
                .body("photoUrls[1]", equalTo("https://example.com/photo2.jpg"))
                .body("photoUrls", hasSize(2))// проверка на размер массива
                .body("category.id", equalTo(category.getId()))
                .body("category.name", equalTo("Dogs"))
                .body("tags[0].id", equalTo(1))
                .body("tags[0].name", equalTo("Braiton"))
                .body("tags[1].id", equalTo(2))
                .body("tags[1].name", equalTo("Molly"))
                .body("tags[2].id", equalTo(3))
                .body("tags[2].name", equalTo("Ruby"))
                .body("tags", hasSize(3))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("pet.json"));

        //Обновляем категорию
        Pet.Category updatedCategory = new Pet.Category(
                faker.number().numberBetween(1001, 2000),
                "Cats"
        );
        //Обновляем список тегов
        List<Pet.Tag> updatedTags = Arrays.asList(
                new Pet.Tag(10, "Tina"),
                new Pet.Tag(11, "Kitty")
        );
        //Обновляем список фото
        List<String> updatedPhotoUrls = Arrays.asList(
                "https://example.com/photo3.jpg"
        );
        // Обновлем питомца
        String updatedPetName = "Luna";
        Pet updatedPet = new Pet(
                petId,
                updatedPetName,
                updatedPhotoUrls,
                "sold",
                updatedCategory,
                updatedTags
        );
        Response putResponse = petApiSteps.updatePet(updatedPet);
        verifyPetInResponse(putResponse, petId, updatedPetName, "sold");   // Проверяем основные поля с помощью нового метода
        putResponse.then().statusCode(200) // проверяем остальные поля
                .body("id", equalTo(petId))
                .body("name", equalTo("Luna"))
                .body("status", equalTo("sold"))
                .body("photoUrls[0]", equalTo("https://example.com/photo3.jpg"))
                .body("photoUrls", hasSize(1))
                .body("category.id", equalTo(updatedCategory.getId()))
                .body("category.name", equalTo("Cats"))
                .body("tags[0].id", equalTo(10))
                .body("tags[0].name", equalTo("Tina"))
                .body("tags[1].id", equalTo(11))
                .body("tags[1].name", equalTo("Kitty"))
                .body("tags", hasSize(2))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("pet.json"));

        //Отправляем GET запрос - проверка обновления
        verifyBasicPetFields(petId, updatedPetName, "sold" );
        petApiSteps.getPetById(petId)
                .then().statusCode(200)
                .body("photoUrls[0]", equalTo("https://example.com/photo3.jpg"))
                .body("photoUrls", hasSize(1))
                .body("category.id", equalTo(updatedCategory.getId()))
                .body("category.name", equalTo("Cats"))
                .body("tags[0].id", equalTo(10))
                .body("tags[0].name", equalTo("Tina"))
                .body("tags[1].id", equalTo(11))
                .body("tags[1].name", equalTo("Kitty"))
                .body("tags", hasSize(2))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("pet.json"));

        //Отправляем DELETE запрос
        petApiSteps.deletePet(petId)
                .then().statusCode(200)
                .body("code", equalTo(200));
        //Отправляем GET запрос - проверяем что удалился
        petApiSteps.getPetById(petId)
                .then().statusCode(404);
    }
}
