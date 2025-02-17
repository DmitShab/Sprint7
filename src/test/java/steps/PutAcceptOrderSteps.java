package steps;

import apirequests.PutApiAcceptOrder;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.PostLoginResponsePOJO;
import testdata.TestData;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

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
    @Step("Проверка корректности ответа при позитивном сценарии")
    public void acceptOrderResponseValidation(){
        response.then().statusCode(200).assertThat().body("ok", equalTo(true));
    }
    @Step("Принятие заказа, не передав id курьера")
    public Response acceptOrderNoCourierId() {
        Integer id = GetOrderByTrackSteps.response.then().extract().body().path("order.id");
        response = putApiAcceptOrder.acceptOrderNoCourierId(id);
        return response;
    }
    @Step("Валидация ответа если не передаем courierId")
    public void acceptOrderResponseValidationNoCourierId(){
        response.then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для поиска"));
    }
    @Step("Принятие заказа, передав id несуществующего курьера")
    public Response acceptOrderNonexistentCourierId() {
        Map<String, Integer> params = new HashMap<>();
        Integer courierId = TestData.generateRandomNumber(9);
        params.put("courierId", courierId);
        Integer id = GetOrderByTrackSteps.response.then().extract().body().path("order.id");
        response = putApiAcceptOrder.acceptOrder(id, params);
        return response;
    }
    @Step("Валидация ответа если передаем id несуществующего курьера")
    public void acceptOrderResponseValidationNonexistentCourierId(){
        response.then().statusCode(404).assertThat().body("message", equalTo("Курьера с таким id не существует"));
    }
    @Step("Принятие заказа,  не передав id заказа")
    public Response acceptOrderNoOrderId() {
        Map<String, Integer> params = new HashMap<>();
        Integer courierId = PostLoginCourierSteps.response.as(PostLoginResponsePOJO.class).getId();
        params.put("courierId", courierId);
        Integer id = GetOrderByTrackSteps.response.then().extract().body().path("order.id");
        response = putApiAcceptOrder.acceptOrderNoOrderId(params);
        return response;
    }
    @Step("Валидация ответа если не передаем id заказа")
    public void acceptOrderResponseValidationNoOrderId(){
        response.then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для поиска"));
    }
    @Step("Принятие заказа, передав id несуществующего заказа")
    public Response acceptOrderNonexistentOrderId() {
        Map<String, Integer> params = new HashMap<>();
        Integer courierId = PostLoginCourierSteps.response.as(PostLoginResponsePOJO.class).getId();
        params.put("courierId", courierId);
        Integer id = TestData.generateRandomNumber(9);
        response = putApiAcceptOrder.acceptOrder(id, params);
        return response;
    }
    @Step("Валидация ответа если не передаем id заказа")
    public void acceptOrderResponseValidationNonexistentOrderId(){
        response.then().statusCode(404).assertThat().body("message", equalTo("Заказа с таким id не существует"));
    }
    @Step("Валидация ответа если приняли тотже самый заказ 1+ раз")
    public void acceptOrderTwice(){
        response.then().statusCode(409 ).assertThat().body("message", equalTo("Этот заказ уже в работе"));
    }
}
