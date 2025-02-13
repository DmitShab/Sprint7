package apiRequests;

import baseHttpClient.BaseHttpClient;
import io.restassured.response.Response;
import pojo.PostLogInPOJO;

public class PostApiLogin extends BaseHttpClient {
    private final String path = "api/v1/courier/login";

    public Response loginCourier(PostLogInPOJO object) {
        return doPostRequest(path, object);
    }

}
