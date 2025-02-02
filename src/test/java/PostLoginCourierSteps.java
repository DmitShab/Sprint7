import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.notNullValue;

public class PostLoginCourierSteps {
    PostApiLogin postApiLogin = new PostApiLogin();
    Response response;

    @Step("Логин существующего курьера")
    public Response loginCourier() {
        PostLogInPOJO postLogInPOJO = new PostLogInPOJO(PostCreateCourierSteps.post.getLogin(), PostCreateCourierSteps.post.getPassword());
        response = postApiLogin.loginCourier(postLogInPOJO);
        return response;
    }
    @Step("Валидация ответа при успешном login")
    public void checkResponse(){
        response.then().statusCode(200).and().assertThat().body("id", notNullValue());
    }
}
