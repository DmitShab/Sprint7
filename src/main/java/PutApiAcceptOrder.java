import io.restassured.response.Response;

import java.util.Map;

public class PutApiAcceptOrder extends BaseHttpClient {
    private final String path = "api/v1/orders/accept/";

    public Response acceptOrder(Integer id, Map<String, Integer> params) {
        return doPutRequest(path + id, params);
    }
}
