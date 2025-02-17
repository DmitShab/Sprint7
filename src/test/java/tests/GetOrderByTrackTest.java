package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.GetOrderByTrackSteps;
import steps.PostMakeOrderSteps;

public class GetOrderByTrackTest {
    PostMakeOrderSteps postMakeOrderSteps = new PostMakeOrderSteps();
    GetOrderByTrackSteps getOrderByTrackSteps = new GetOrderByTrackSteps();

    @Test
    @DisplayName("Получение заказа по сущестующему track")
    public void getOrderCheck() {
        Integer track = postMakeOrderSteps.makeOrderStep().getTrack();
        getOrderByTrackSteps.getOrderByTrack(track);
        getOrderByTrackSteps.validateResponse(track);
    }

    @Test
    @DisplayName("Получение заказа не передав track")
    public void getOrderNoTrack() {
        postMakeOrderSteps.makeOrderStep();
        getOrderByTrackSteps.getOrderNoTrack();
        getOrderByTrackSteps.validateResponseNoTrack();
    }
    @Test
    @DisplayName("Получение заказа, передав несуществующий track")
    public void getOrderNonexistent() {
        postMakeOrderSteps.makeOrderStep();
        getOrderByTrackSteps.getOrderByNonexistentTrack();
        getOrderByTrackSteps.validateResponseNonexistentTrack();
    }
}
