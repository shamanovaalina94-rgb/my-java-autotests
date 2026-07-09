package api.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

public class ApiDeleteTest {

    @Test
    void deletePost() {
        given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(204)));
    }
}
