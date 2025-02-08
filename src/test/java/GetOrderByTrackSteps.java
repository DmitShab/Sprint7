import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetOrderByTrackSteps {
    GetApiGetOrder getApiGetOrder = new GetApiGetOrder();
    static Response response;

    @Step("Получение номера по track")
    public Response getOrderByTrack(Integer track) {
        Map<String, Integer> params = new HashMap<>();
        params.put("t", track);
        response = getApiGetOrder.getOrder(params);
        return response;
    }

    @Step("Валидция ответа при 200 ok")
    public void validateResponse(Integer track) {
        response.then().statusCode(200).assertThat().body("order.track", equalTo(track));
    }
}

