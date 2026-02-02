package api.tests;

import api.base.BaseApiTest;
import api.steps.OrderApiSteps;
import com.github.javafaker.Faker;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import api.models.Order;
import static org.hamcrest.Matchers.equalTo;

public class OrderApiTest extends BaseApiTest {

    private final OrderApiSteps orderApiSteps = new OrderApiSteps();
    private int orderId;

    @Test
    void testCreateOrder(){
        Faker faker = new Faker();
        //СОЗДАЕМ ЗАКАЗ
        Order order = new Order(
                faker.number().numberBetween(1, 10),
                faker.number().numberBetween(1, 100),
                faker.number().numberBetween(1, 5),
                "2027-01-01T13:00:02.133Z",
                "placed",
                true
        );
        orderId = order.getId(); //сохраняем id для следующих проверок
        //Отправляем POST запрос для создания заказа
        var response = orderApiSteps.createOrder(order);
        //Проверяем что создалось
        response.then().statusCode(200)
                .body("id", equalTo(orderId))
                .body("status", equalTo(order.getStatus()));
        //ОТПРАВЛЯЕМ GET ЗАПРОС
        orderApiSteps.getOrderById(orderId)
                .then().statusCode(200).
                body("id", equalTo(orderId))
                .body("status", equalTo(order.getStatus()))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("order.json"));
        //УДАЛЯЕМ ЗАКАЗ
        orderApiSteps.deleteOrder(orderId)
                .then().statusCode(200);
        // ОТПРАВЛЯЕМ GET ЗАПРОС - проверяем что удалился
        orderApiSteps.getOrderById(orderId)
                .then().statusCode(404);
    }
}
