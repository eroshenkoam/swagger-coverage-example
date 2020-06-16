package io.eroshenkoam.swagger;

import com.github.viclovsky.swagger.coverage.CoverageOutputWriter;
import com.github.viclovsky.swagger.coverage.FileSystemOutputWriter;
import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.viclovsky.swagger.coverage.SwaggerCoverageConstants.OUTPUT_DIRECTORY;

public final class RestAssuredUtil {

    private RestAssuredUtil() {
    }

    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .addFilter(new SwaggerCoverageRestAssured(defaultWriter()))
                .setBaseUri("https://petstore.swagger.io/v2")
                .addHeader("Accept", "application/json")
                .build();
    }

    private static CoverageOutputWriter defaultWriter() {
        final Path build = Paths.get("build");
        return new FileSystemOutputWriter(build.resolve(OUTPUT_DIRECTORY));
    }

}
