package baseHttpClient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import URL.*;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {
    private RequestSpecification baseRequestSpec = new RequestSpecBuilder()
            .setBaseUri(URL.HOST)
            .addHeader("Content-Type", "application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();

    protected Response doPostRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpec)
                .body(body)
                .when().post(path)
                .thenReturn();

    }

    protected Response doGetRequest(String path, Map<String, Integer> params) {
        return given()
                .spec(baseRequestSpec)
                .params(params)
                .get(path)
                .thenReturn();
    }

    protected Response doDeleteRequest(String path) {
        return given()
                .spec(baseRequestSpec)
                .delete(path)
                .thenReturn();
    }

    protected Response doPutRequest(String path, Map<String, Integer> params) {
        return given()
                .spec(baseRequestSpec)
                .params(params)
                .put(path)
                .thenReturn();
    }
    protected Response doPutRequestWithoutCourierId(String path, String pathForParam) {
        return given()
                .spec(baseRequestSpec)
                .put(path+pathForParam)
                .thenReturn();
    }
}
