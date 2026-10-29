package tests;

import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTests extends BaseApiTest {

    @Test(description = "Verify GET /users returns 200 OK and list of users")
    public void testGetUsersSuccess() {
        given()
                .spec(requestSpec)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("size()", greaterThan(0))
                .body("[0].name", notNullValue())
                .body("[0].email", containsString("@"));
    }

    @Test(description = "Verify GET /users/{id} retrieves correct user record")
    public void testGetSingleUserById() {
        given()
                .spec(requestSpec)
                .pathParam("id", 1)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"))
                .body("address.city", notNullValue());
    }

    @Test(description = "Verify POST /users creates a new user entity with 201 Created")
    public void testCreateUser() {
        String requestBody = "{\n" +
                "  \"name\": \"Shennar Lar\",\n" +
                "  \"username\": \"shennarlar\",\n" +
                "  \"email\": \"shennar.test@example.com\"\n" +
                "}";

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Shennar Lar"))
                .extract().response();

        Assert.assertNotNull(response.jsonPath().get("id"), "Generated ID should not be null");
    }

    @Test(description = "Verify GET returns 404 Not Found for non-existent resource")
    public void testGetNonExistentUserReturns404() {
        given()
                .spec(requestSpec)
                .pathParam("id", 9999)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(404);
    }
}
