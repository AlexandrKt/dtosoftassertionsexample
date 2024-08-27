package com.dtosoftassertionsexample.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.dtosoftassertionsexample.helpers.ApiHeaderHelper.getRequestSpec;
import static io.restassured.RestAssured.given;

public class ApiUtil {
    static RequestSpecification requestSpec = getRequestSpec();
    public static Response sendGetRequest(String endpoint, String date) {

        return requestSpec.given().queryParam("json").queryParam("date",date).when().get(endpoint);
    }
    public static Response sendPostRequest(String endpoint, Map<String, Object> reqBody) {
        return requestSpec
                .body(reqBody)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
