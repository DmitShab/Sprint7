package Tests;

import POJO.CreateCourierPOJO;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateCourierTest {
    String login = "Jnasdasdas";
    String password  = "12sd!sad!";
    String firstName = "Billiesha";
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
        public void checkIfUserExistsIfTrueThenDelete () {

        }
    }

    @Test
    @DisplayName("Создание курьера /api/v1/courier")
    public void createCourierMethod() {
        Response response = sendPostToCreateCourier();
        response.then().statusCode(201)
                .and().assertThat(response.isOk(), is(equalTo(true)));

    }

    @Test
    @DisplayName("Создание двух одинаковых курьеров /api/v1/courier")
    public void createTwoSameCouriers() {
        sendPostToCreateCourier();
        Response response = sendPostToCreateCourier();
        response.then().statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется"));
    }

    @Step("POST Создание курьера /api/v1/courier ")
    public Response sendPostToCreateCourier() {
        CreateCourierPOJO createCourierPOJO = new CreateCourierPOJO(login, password, firstName);
        Response response = given()
                .header("Content-type", "application/json")
                .body(createCourierPOJO)
                .when()
                .post("api/v1/courier");
        return response;
    }
    @Step("POST")

}
