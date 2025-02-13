package apiRequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;
import pojo.PostCreatePOJO;

public class PostApiCreate extends BaseHttpClient {
    private final String path = "api/v1/courier";

    public Response createCourier(PostCreatePOJO body) {
        return doPostRequest(path, body);
    }
}
