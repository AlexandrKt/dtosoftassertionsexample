package com.dtosoftassertionsexample.helpers;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHeaderHelper {

    public static RequestSpecification getRequestSpec() {
        return given()
                .header("Content-Type", "application/json")
                .log().all();  // This will log all request details
    }
}
