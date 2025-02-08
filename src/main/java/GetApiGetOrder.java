import io.restassured.response.Response;

import java.util.Map;

public class GetApiGetOrder extends BaseHttpClient {
    private final String path = "api/v1/orders/track";

    public Response getOrder(Map<String, Integer> params) {
        return doGetRequest(path, params);
    }

}
