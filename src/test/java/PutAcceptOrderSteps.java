import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class PutAcceptOrderSteps {
    PutApiAcceptOrder putApiAcceptOrder = new PutApiAcceptOrder();
    Response response;

    @Step("Принятие заказа")
    public Response acceptOrder() {
        Map<String, Integer> params = new HashMap<>();
        Integer courierId = PostLoginCourierSteps.response.as(PostLoginResponsePOJO.class).getId();
        params.put("courierId", courierId);
        Integer id = GetOrderByTrackSteps.response.then().extract().body().path("order.id");
        response = putApiAcceptOrder.acceptOrder(id, params);
        return response;
    }
}
