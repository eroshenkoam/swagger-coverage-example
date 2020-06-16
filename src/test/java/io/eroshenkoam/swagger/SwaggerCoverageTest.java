package io.eroshenkoam.swagger;

import org.junit.jupiter.api.Test;

import static io.eroshenkoam.swagger.RestAssuredUtil.defaultSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerCoverageTest {

    @Test
    public void testCoverage() {
        // @formatter:off
        given().spec(defaultSpec())
        .when()
            .get("/pet/{id}", 1)
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
        // @formatter:on

    }

}
