import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PostAcceptOrderTests {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    PostMakeOrderSteps postMakeOrderSteps = new PostMakeOrderSteps();
    GetOrderByTrackSteps getOrderByTrackSteps = new GetOrderByTrackSteps();
    PutAcceptOrderSteps putAcceptOrderSteps = new PutAcceptOrderSteps();

    @Test
    @DisplayName("Принятие заказа")
    public void acceptOrder() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrder();
        putAcceptOrderSteps.acceptOrderResponseValidation();
    }

    @Test
    @DisplayName("Принятие заказа, не передав id курьера")
    public void acceptOrderNoCourierId() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrderNoCourierId();
        putAcceptOrderSteps.acceptOrderResponseValidationNoCourierId();
    }
    @Test
    @DisplayName("Принятие заказа, передав id несуществующего курьера")
    public void acceptOrderNonexistentCourierId() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrderNonexistentCourierId();
        putAcceptOrderSteps.acceptOrderResponseValidationNonexistentCourierId();
    }
    @Test
    @DisplayName("Принятие заказа, не передав id заказа")
    public void acceptOrderNoOrderId() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrderNoOrderId();
        putAcceptOrderSteps.acceptOrderResponseValidationNoOrderId();
    }
    @Test
    @DisplayName("Принятие заказа, передав id несуществующего курьера")
    public void acceptOrderNonexistentOrderId() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrderNonexistentOrderId();
        putAcceptOrderSteps.acceptOrderResponseValidationNonexistentOrderId();
    }
    @Test
    @DisplayName("Принятие заказа")
    public void acceptOrderTwice() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        putAcceptOrderSteps.acceptOrder();
        putAcceptOrderSteps.acceptOrder();
        putAcceptOrderSteps.acceptOrderTwice();
    }
}