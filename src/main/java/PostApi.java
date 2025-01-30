import io.restassured.response.Response;

public class PostApi extends BaseHttpClient {
    private final String path = "api/v1/courier";

    public Response createCourier(Object body) {
        return doPostRequest(path, body);
    }
}
