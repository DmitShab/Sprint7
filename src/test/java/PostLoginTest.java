import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

public class PostLoginTest {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    DeleteCourierSteps deleteCourierSteps = new DeleteCourierSteps();

    @After
    public void deleteTestUsers() {
        deleteCourierSteps.deleteCourier();
    }

    @Test
    @DisplayName("Авторизация существующего курьера")
    public void loginTest() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        postLoginCourierSteps.checkResponse();

    }

    @Test
    @DisplayName("Проверка авторизации без заполнения обязательных полей Login")
    public void negLoginTest() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.doLoginNoRequiredLoginField();
    }

    @Test
    @DisplayName("Проверка авторизации без заполнения обязательных полей Password")
    public void negPasswordTest() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.doLoginNoRequiredPasswordFiled();
    }

    @Test
    @DisplayName("Логин курьера с несуществующем логином, существующим паролем")
    public void incorrectLoginTest() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.doLoginIncorrectLogin();
    }

    @Test
    @DisplayName("Логин курьера с несуществующем паролем, существующим логином")
    public void incorrectPasswordTest() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.doLoginIncorrectPassword();
    }

    @Test
    @DisplayName("Логин курьера с несуществующем паролем, существующим логином")
    public void nonExistentUserLoginTest() {
        postLoginCourierSteps.doLoginNonexistentUser();
    }
}
