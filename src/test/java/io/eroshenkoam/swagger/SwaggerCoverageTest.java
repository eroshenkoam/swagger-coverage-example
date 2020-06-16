package io.eroshenkoam.swagger;

import org.junit.jupiter.api.Test;

import static io.eroshenkoam.swagger.RestAssuredUtil.defaultSpec;
import static io.restassured.RestAssured.given;

public class SwaggerCoverageTest {

    @Test
    public void testCoverage() {
        // @formatter:off
        given().spec(defaultSpec())
        .when()
            .get("/pet/{id}", 1)
        .then()
            .statusCode(404);
        // @formatter:on

    }

}
