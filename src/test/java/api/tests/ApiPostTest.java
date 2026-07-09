package api.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiPostTest {

    @Test
    void createPost() {
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "title": "foo",
                            "body": "bar",
                            "userId": 1
                        }
                        """)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("id", notNullValue());
    }
}
