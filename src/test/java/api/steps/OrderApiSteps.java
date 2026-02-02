package api.steps;

import api.base.BaseApiTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.models.Order;

public class OrderApiSteps extends BaseApiTest {

    @Step ("Создаем заказ")
    public Response createOrder(Order order) {
        logger.info("Отправляем POST запрос на /v2/store/order для заказа '{}'", order.getId());
        return requestSpecification().body(order).post("/v2/store/order");
    }
    @Step ("Получаем заказ по id {id}")
    public Response getOrderById(int id){
        logger.info("Отправляем GET запрос на /v2/store/order/'{}'", id);
        return requestSpecification().get("/v2/store/order/" + id);
    }
    @Step("Удаляем заказ по id {id}")
    public Response deleteOrder(int id){
        logger.info("Отправляем DELETE запрос на /v2/store/order/'{}'", id );
        return requestSpecification().delete("/v2/store/order/" + id);
    }
}
