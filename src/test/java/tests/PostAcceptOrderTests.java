package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.*;

public class PostAcceptOrderTests {
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    PostLoginCourierSteps postLoginCourierSteps = new PostLoginCourierSteps();
    PostMakeOrderSteps postMakeOrderSteps = new PostMakeOrderSteps();
    GetOrderByTrackSteps getOrderByTrackSteps = new GetOrderByTrackSteps();
    PutAcceptOrderSteps putAcceptOrderSteps = new PutAcceptOrderSteps();
    DeleteCourierSteps deleteCourierSteps = new DeleteCourierSteps();

    @Before
    public void createTestUserAndOrder() {
        postCreateCourierSteps.createCourier();
        postLoginCourierSteps.loginCourier();
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
    }

    @After
    public void deleteTestUsers() {
        deleteCourierSteps.deleteCourier();
    }

    @Test
    @DisplayName("Принятие заказа")
    public void acceptOrder() {

        putAcceptOrderSteps.acceptOrder();
        putAcceptOrderSteps.acceptOrderResponseValidation();
    }

    @Test
    @DisplayName("Принятие заказа, не передав id курьера")
    public void acceptOrderNoCourierId() {

        putAcceptOrderSteps.acceptOrderNoCourierId();
        putAcceptOrderSteps.acceptOrderResponseValidationNoCourierId();
    }

    @Test
    @DisplayName("Принятие заказа, передав id несуществующего курьера")
    public void acceptOrderNonexistentCourierId() {

        putAcceptOrderSteps.acceptOrderNonexistentCourierId();
        putAcceptOrderSteps.acceptOrderResponseValidationNonexistentCourierId();
    }

    @Test
    @DisplayName("Принятие заказа, не передав id заказа")
    public void acceptOrderNoOrderId() {

        putAcceptOrderSteps.acceptOrderNoOrderId();
        putAcceptOrderSteps.acceptOrderResponseValidationNoOrderId();
    }

    @Test
    @DisplayName("Принятие заказа, передав id несуществующего курьера")
    public void acceptOrderNonexistentOrderId() {

        putAcceptOrderSteps.acceptOrderNonexistentOrderId();
        putAcceptOrderSteps.acceptOrderResponseValidationNonexistentOrderId();
    }

    @Test
    @DisplayName("Принятие заказа")
    public void acceptOrderTwice() {

        putAcceptOrderSteps.acceptOrder();
        putAcceptOrderSteps.acceptOrder();
        putAcceptOrderSteps.acceptOrderTwice();
    }
}