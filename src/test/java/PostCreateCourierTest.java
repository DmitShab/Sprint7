import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class PostCreateCourierTest {
    private PostApi postApi = new PostApi();
    @Test
    public void postCrateCourierTest(){
Post post = new Post("sdfsd6vjkjk8f","dafsdf123","asd123sd");
        PostResponsePOJO response = postApi.createCourier(post);
//        response.then().assertThat().statusCode(201);
        assertEquals(true, response.getOk());
    }
}
