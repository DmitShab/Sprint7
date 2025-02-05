import io.restassured.response.Response;

public class DeleteApiCourier extends BaseHttpClient {
    private final String path = "api/v1/courier/";

    public Response deleteCourier(Integer id) {
        return doDeleteRequest(path + id);
    }
    public Response deleteCourierNoId() {
        return doDeleteRequest(path);
    }
}
