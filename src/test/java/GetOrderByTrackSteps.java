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
    @Step("Получение номера не переда параметр track")
    public Response getOrderNoTrack() {
        Map<String, Integer> params = new HashMap<>();
        response = getApiGetOrder.getOrder(params);
        return response;
    }
    @Step("Валидация ответа не передав параметр track")
    public void validateResponseNoTrack() {
        response.then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для поиска"));
    }
    @Step("Получение номера передав несуществующий track")
    public Response getOrderByNonexistentTrack() {
        Map<String, Integer> params = new HashMap<>();
        params.put("t", TestData.generateRandomNumber(9));
        response = getApiGetOrder.getOrder(params);
        return response;
    }
    @Step("Валидация ответа передав несуществущий track")
    public void validateResponseNonexistentTrack() {
        response.then().statusCode(404).assertThat().body("message", equalTo("Заказ не найден"));
    }
}

