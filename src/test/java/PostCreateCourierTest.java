import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class PostCreateCourierTest {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    @Test
    @DisplayName("Создание курьера")
    public void postCrateCourierTest() {
        postCreateCourierSteps.createCourier();
        postCreateCourierSteps.checkResponseBody();
    }
}
