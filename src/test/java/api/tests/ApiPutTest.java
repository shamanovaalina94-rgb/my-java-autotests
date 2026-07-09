package api.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiPutTest {

    @Test
    void updatePostTitle() {
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "title": "updated title"
                        }
                        """)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("updated title"));
    }
}
