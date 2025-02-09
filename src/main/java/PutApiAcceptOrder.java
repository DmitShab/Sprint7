import io.restassured.response.Response;

import java.util.Map;

public class PutApiAcceptOrder extends BaseHttpClient {
    private final String path = "api/v1/orders/accept/";
    private final String pathForParam = "?courierId=";

    public Response acceptOrder(Integer id, Map<String, Integer> params) {
        return doPutRequest(path + id, params);
    }

    public Response acceptOrderNoCourierId(Integer id) {
        return doPutRequestWithoutCourierId(path + id , pathForParam);
    }
    public Response acceptOrderNoOrderId(Map<String, Integer> params) {
        return doPutRequest(path, params);
    }
}
