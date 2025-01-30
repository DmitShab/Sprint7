import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateCourierSteps {
    private PostApi postApi = new PostApi();
    private Response response;

    @Step("Создание курьера")
    public Response createCourier() {
        Post post = new Post("sdfsd6vjklcvbjk8f", "dafsdf123", "asd123sd");
        response = postApi.createCourier(post);
        return response;
    }

    @Step("Провалидировали код-статус и тело ответа")
    public void checkResponseBody() {
        response.then()
                .assertThat().body("ok", equalTo(true)).statusCode(201);
    }
}

