import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
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
    public void checkResponse() {
        response.then().statusCode(200).and().assertThat().body("id", notNullValue());
    }

    @Step("Логин курьера без заполнения обязаьельных полей Login")
    public void doLoginNoRequiredLoginField() {
        PostLogInPOJO postLogInPOJO = new PostLogInPOJO(null, PostCreateCourierSteps.post.getPassword());
        postApiLogin.loginCourier(postLogInPOJO).then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Step("Логин курьера без заполнения обязаьельных полей Password")
    public void doLoginNoRequiredPasswordFiled() {
        PostLogInPOJO postLogInPOJO = new PostLogInPOJO(PostCreateCourierSteps.post.getLogin(), null);
        postApiLogin.loginCourier(postLogInPOJO).then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Step("Логин курьера с несуществующем логином, существующим паролем")
    public void doLoginIncorrectLogin() {
        PostLogInPOJO postLogInPOJO = new PostLogInPOJO(TestData.generateRandomString(10), PostCreateCourierSteps.post.getPassword());
        postApiLogin.loginCourier(postLogInPOJO).then().statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Step("Логин курьера с существующем логином, несуществующим паролем")
    public void doLoginIncorrectPassword() {
        PostLogInPOJO postLogInPOJO = new PostLogInPOJO(PostCreateCourierSteps.post.getLogin(), TestData.generateRandomString(10));
        postApiLogin.loginCourier(postLogInPOJO).then().statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Step("Авторизация под несуществущим пользователем")
    public void doLoginNonexistentUser() {
        PostLogInPOJO postLogInPOJO = new PostLogInPOJO(PostCreateCourierSteps.post.getLogin(), TestData.generateRandomString(10));
        postApiLogin.loginCourier(postLogInPOJO).then().statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));

    }
}