import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateCourierSteps {
    private PostApi postApi = new PostApi();
    private Response response;

    @Step("Создание курьера")
    public Response createCourier(String login, String password, String firstName) {
        Post post = new Post(login, password, firstName);
        response = postApi.createCourier(post);
        return response;
    }
    @Step("Создание курьера")
    public Response createCourier() {
        Post post = new Post("sdfsd6vjkbnmlcvbjk8f", "dafsdf123", "asd123sd");
        response = postApi.createCourier(post);
        return response;
    }

    @Step("Провалидировали код-статус и тело ответа при успешном запросе")
    public void checkResponseBodyPos() {
        response.then()
                .assertThat().body("ok", equalTo(true)).statusCode(201);
    }
    @Step("Проверили создание двух одинаковых курьеров")
    public void checkResponseBodyNeg(){
        response.then().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется"));
    }
@Step("Создание курьера без обязательных полей")
    public void checkResponseNoRequiredFields(){
    response.then().statusCode(400)
            .and()
            .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
}
}
