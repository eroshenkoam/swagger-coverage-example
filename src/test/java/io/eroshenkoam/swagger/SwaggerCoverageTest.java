package io.eroshenkoam.swagger;

import io.eroshenkoam.swagger.petstore.Pet;
import org.junit.jupiter.api.Test;

import static io.eroshenkoam.swagger.RestAssuredUtil.defaultSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerCoverageTest {

    @Test
    public void testCoverage() {
        final Pet pet = new Pet()
                .setName("chappy")
                .setStatus("available");

        // @formatter:off
        final Pet created = given().spec(defaultSpec()).body(pet)
        .when()
            .post("/pet")
        .then()
            .extract()
            .as(Pet.class);

        given().spec(defaultSpec())
        .when()
            .get("/pet/{id}", created.getId())
        .then()
            .statusCode(200)
            .body("name", equalTo(pet.getName()));
        // @formatter:on

    }

}
