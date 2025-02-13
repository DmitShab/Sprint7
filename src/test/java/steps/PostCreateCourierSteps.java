package steps;

import apiRequests.PostApiCreate;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.*;
import testData.TestData;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateCourierSteps {
    private PostApiCreate postApi = new PostApiCreate();
    private Response response;
    static PostCreatePOJO post;

    //Шаг для параметризированного теста
    @Step("Создание курьера без обязательных полей")
    public Response createCourier(String login, String password, String firstName) {
        PostCreatePOJO post = new PostCreatePOJO(login, password, firstName);
        response = postApi.createCourier(post);
        return response;
    }

    @Step("Создание курьера")
    public Response createCourier() {
        post = new PostCreatePOJO(TestData.generateRandomString(10), TestData.generateRandomString(10), TestData.generateRandomString(10));
        response = postApi.createCourier(post);
        return response;
    }
    @Step("Создание курьера дублера")
    public Response createCourierDouble() {
        post = new PostCreatePOJO(post.getLogin(),post.getPassword() , post.getFirstName());
        response = postApi.createCourier(post);
        return response;
    }

    @Step("Провалидировали код-статус и тело ответа при успешном запросе")
    public void checkResponseBodyPos() {
        response.then()
                .assertThat().body("ok", equalTo(true)).statusCode(201);
    }

    @Step("Проверили создание двух одинаковых курьеров")
    public void checkResponseBodyNeg() {
        response.then().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется"));
    }

    @Step("Создание курьера без обязательных полей")
    public void checkResponseNoRequiredFields() {
        response.then().statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
