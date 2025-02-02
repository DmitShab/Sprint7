import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class DeleteCourierSteps {
    DeleteApiCourier deleteApiCourier = new DeleteApiCourier();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    Response response;


    @Step("Удаление курьера")
    public Response deleteCourier() {
        PostLoginResponsePOJO post1 = (postLoginCourierSteps.loginCourier().as(PostLoginResponsePOJO.class));
        response = deleteApiCourier.deleteCourier(post1.getId());
        return response;
    }
}
