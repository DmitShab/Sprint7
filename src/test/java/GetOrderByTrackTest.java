import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

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
}
