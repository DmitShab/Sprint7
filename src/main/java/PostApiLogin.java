import io.restassured.response.Response;

public class PostApiLogin extends BaseHttpClient {
    private final String path = "api/v1/courier/login";

    public Response loginCourier(PostLogInPOJO object) {
        return doPostRequest(path, object);
    }

}
