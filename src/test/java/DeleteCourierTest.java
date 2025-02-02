import org.junit.Test;

public class DeleteCourierTest {
    DeleteCourierSteps deleteCourierSteps = new DeleteCourierSteps();
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    @Test
    public void deleteCourier(){
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        deleteCourierSteps.deleteCourier();
    }
}
