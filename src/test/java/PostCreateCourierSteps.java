import io.qameta.allure.Step;

public class PostCreateCourierSteps {
    private PostApi postApi = new PostApi();

    @Step("Создание курьера")
    public void createCourier(){
        Post post = new Post("sdfsd6vjkjk8f","dafsdf123","asd123sd");
        PostResponsePOJO response = postApi.createCourier(post);
    }
}
