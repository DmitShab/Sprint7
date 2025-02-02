import io.restassured.response.Response;
import org.junit.Test;

public class PostLoginTest {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();

    @Test
    public void loginTest() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        postLoginCourierSteps.checkResponse();

    }
}
