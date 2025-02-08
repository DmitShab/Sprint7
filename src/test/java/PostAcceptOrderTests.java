import org.junit.Test;

public class PostAcceptOrderTests {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    PostMakeOrderSteps postMakeOrderSteps = new PostMakeOrderSteps();
    GetOrderByTrackSteps getOrderByTrackSteps = new GetOrderByTrackSteps();
    PutAcceptOrderSteps putAcceptOrderSteps = new PutAcceptOrderSteps();

    @Test
    public void acceptOrder(){
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrder();
    }
}
