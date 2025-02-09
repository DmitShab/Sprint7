import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostLoginTest {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    DeleteCourierSteps deleteCourierSteps = new DeleteCourierSteps();

    @Before
    public void createTestUser() {
        postCreateCourierSteps.createCourier();
    }

    @After
    public void deleteTestUsers() {
        deleteCourierSteps.deleteCourier();
    }

    @Test
    @DisplayName("Авторизация существующего курьера")
    public void loginTest() {
        postLoginCourierSteps.loginCourier();
        postLoginCourierSteps.checkResponse();

    }

    @Test
    @DisplayName("Проверка авторизации без заполнения обязательных полей Login")
    public void negLoginTest() {
        postLoginCourierSteps.doLoginNoRequiredLoginField();
    }

    @Test
    @DisplayName("Проверка авторизации без заполнения обязательных полей Password")
    public void negPasswordTest() {
        postLoginCourierSteps.doLoginNoRequiredPasswordFiled();
    }

    @Test
    @DisplayName("Логин курьера с несуществующем логином, существующим паролем")
    public void incorrectLoginTest() {
        postLoginCourierSteps.doLoginIncorrectLogin();
    }

    @Test
    @DisplayName("Логин курьера с несуществующем паролем, существующим логином")
    public void incorrectPasswordTest() {
        postLoginCourierSteps.doLoginIncorrectPassword();
    }

    @Test
    @DisplayName("Логин курьера с несуществующем паролем, существующим логином")
    public void nonExistentUserLoginTest() {
        postLoginCourierSteps.doLoginNonexistentUser();
    }
}
