package io.eroshenkoam.swagger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LogFilter implements Filter {
    @Override
    public Response filter(final FilterableRequestSpecification requestSpec,
                           final FilterableResponseSpecification responseSpec,
                           final FilterContext ctx) {
        final String method = requestSpec.getMethod();
        System.out.println(String.format("Method: %s", method));

        final String uri = requestSpec.getURI();
        System.out.println(String.format("URI: %s", uri));

        requestSpec.getHeaders().forEach(header -> {
            System.out.println(String.format("Header: %s=%s", header.getName(), header.getValue()));
        });

        return ctx.next(requestSpec, responseSpec);
    }
}
