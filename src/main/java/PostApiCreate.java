import io.restassured.response.Response;

public class PostApiCreate extends BaseHttpClient {
    private final String path = "api/v1/courier";

    public Response createCourier(PostCreatePOJO body) {
        return doPostRequest(path, body);
    }
}
