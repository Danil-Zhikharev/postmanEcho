package ru.netology.postmanEcho;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class postmanEchoApiTest1 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void postManifestN1() {
        String requestBody = "{\"name\":\"myFirstPostApiByJava\",\"date\":\"24.02.2022\",\"message\":\"noWar\"}";
        requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(requestBody);
        response = requestSpecification.post("/post");
        String responseString = response.prettyPrint();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
        validatableResponse.body("data.name", equalTo("myFirstPostApiByJava"));
        validatableResponse.body("data.date", equalTo("24.02.2022"));
        validatableResponse.body("data.message", equalTo("noWar"));
    }
}
