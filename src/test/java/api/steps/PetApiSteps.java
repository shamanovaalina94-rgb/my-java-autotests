package api.steps;

import api.base.BaseApiTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.models.Pet;

public class PetApiSteps extends BaseApiTest {

    @Step ("Создаем питомца")
    public Response createPet (Pet pet){
        logger.info("Отправляем POST запрос на /v2/pet для питомца '{}'", pet.getId());
        return requestSpecification().body(pet).post("/v2/pet");
    }
    @Step("Получаем питомца по id {id}")
    public Response getPetById(int id){
        logger.info("Отправляем GET запрос на /v2/pet/'{}'", id );
        return requestSpecification().get("/v2/pet/" + id);
    }
    @Step("Обновляем питомца")
    public Response updatePet(Pet pet){
        logger.info("Отправляем PUT запрос на /v2/pet для питомца'{}'", pet.getId());
        return requestSpecification().body(pet).put("/v2/pet");
    }
    @Step("Удаляем питомца по id {id}")
    public Response deletePet(int id){
        logger.info("Отправляем DELETE запрос на /v2/pet/'{}", id);
        return requestSpecification().delete("/v2/pet/" + id);
    }
}
