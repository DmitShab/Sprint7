package steps;

import apiRequests.DeleteApiCourier;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.PostLoginResponsePOJO;
import testData.TestData;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCourierSteps {
    DeleteApiCourier deleteApiCourier = new DeleteApiCourier();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    Response response;


    @Step("Удаление курьера")
    public Response deleteCourier() {
        PostLoginResponsePOJO post1 = (postLoginCourierSteps.loginCourier().as(PostLoginResponsePOJO.class));
        response = deleteApiCourier.deleteCourier(post1.getId());
        response.then().statusCode(200).assertThat().body("ok", equalTo(true));
        return response;
    }

    @Step("Удаление курьера, не передав id")
    public Response deleteCourierNoId() {
        deleteApiCourier.deleteCourierNoId()
                .then().statusCode(400)
                .assertThat().body("message", equalTo("Недостаточно данных для удаления курьера"));
        return response;
    }
    @Step("Удаление курьера, передав несуществующий id")
    public Response deleteCourierWrongId() {
        deleteApiCourier.deleteCourier(TestData.generateRandomNumber(9))
                .then().statusCode(404)
                .assertThat().body("message", equalTo("Курьера с таким id нет"));
        return response;
    }
}
