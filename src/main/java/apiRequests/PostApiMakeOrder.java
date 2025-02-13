package apiRequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;
import pojo.PostMakeOrderRequestPOJO;

public class PostApiMakeOrder extends BaseHttpClient {
    private final String path = "api/v1/orders";

    public Response makeOrder(PostMakeOrderRequestPOJO body) {
        return doPostRequest(path, body);
    }
}