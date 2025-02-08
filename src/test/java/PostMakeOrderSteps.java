import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

public class PostMakeOrderSteps {
    PostApiMakeOrder postApiMakeOrder = new PostApiMakeOrder();

    @Step("Создание заказа")
    public GetMakeOrderResponsePOJO makeOrderStep() {
        PostMakeOrderRequestPOJO postMakeOrderRequestPOJO = new PostMakeOrderRequestPOJO(
                TestData.generateRandomString(10),
                TestData.generateRandomString(10),
                TestData.generateRandomString(10),
                TestData.generateRandomNumber(1),
                TestData.generateRandomString(10),
                TestData.generateRandomNumber(1),
                TestData.generateRandomDate(),
                TestData.generateRandomString(10),
                List.of("GREY"));

        return postApiMakeOrder.makeOrder(postMakeOrderRequestPOJO).as(GetMakeOrderResponsePOJO.class);
    }
}
