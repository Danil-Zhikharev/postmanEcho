package ru.netology.postmanEcho;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class postmanEchoApiTest1 {
    @Test
    void shouldReturnNothing() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com/post?hand=wave")
                .body("lol")
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("body", equalTo("lol"));
    }
}
