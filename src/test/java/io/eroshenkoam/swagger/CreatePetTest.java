package io.eroshenkoam.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreatePetTest {

    @Test
    public void testPetCreation() {
        final RequestSpecification spec =  new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addFilter(new SwaggerCoverageRestAssured())
                .build();

        final Pet pet = new Pet();
        pet.setName("chappy");
        pet.setStatus("available");

        final Pet created = given()
            .spec(spec)
            .body(pet)
        .when()
            .post("/pet")
        .then()
            .extract()
            .as(Pet.class);

        given()
           .spec(spec)
        .when()
            .get("/pet/{id}", created.getId())
        .then()
            .statusCode(200)
            .body("name", equalTo(pet.getName()));
    }

}
