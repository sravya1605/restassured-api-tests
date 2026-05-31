package com.qatest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testGetUserReturns200() {
        given()
            .when()
                .get("/users/2")
            .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", notNullValue());
    }

    @Test
    public void testGetUserListReturnsMultipleUsers() {
        given()
            .when()
                .get("/users?page=1")
            .then()
                .statusCode(200)
                .body("data.size()", greaterThan(0))
                .body("page", equalTo(1));
    }

    @Test
    public void testCreateUserReturns201() {
        String requestBody = "{ \"name\": \"sravya\", \"job\": \"qa-engineer\" }";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
                .post("/users")
            .then()
                .statusCode(201)
                .body("name", equalTo("sravya"))
                .body("job", equalTo("qa-engineer"))
                .body("id", notNullValue());
    }

    @Test
    public void testGetNonExistentUserReturns404() {
        given()
            .when()
                .get("/users/999")
            .then()
                .statusCode(404);
    }
}
