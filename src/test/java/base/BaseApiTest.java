package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    protected static RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        // Base URI for public REST API endpoints
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();
    }
}
