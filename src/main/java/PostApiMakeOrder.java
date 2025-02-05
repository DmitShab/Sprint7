import io.restassured.response.Response;

public class PostApiMakeOrder extends BaseHttpClient {
    private final String path = "api/v1/orders";

    public Response makeOrder(PostMakeOrderRequestPOJO body) {
        return doPostRequest(path, body);
    }
}