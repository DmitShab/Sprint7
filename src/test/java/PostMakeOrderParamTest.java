import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static jdk.dynalink.linker.support.Guards.isNotNull;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class PostMakeOrderParamTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final Integer metroStation;
    private final String phone;
    private final Integer rentTime;
    private final String deliveryDate;
    private final String comment;
    private final List<String> color;

    public PostMakeOrderParamTest(String firstName, String lastName, String address, Integer metroStation, String phone, Integer rentTime, String deliveryDate, String comment, List<String> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomDate(),
                        TestData.generateRandomString(10),
                        List.of("GREY"),
                },
                {
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomDate(),
                        TestData.generateRandomString(10),
                        List.of("BLACK"),
                },
                {
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomDate(),
                        TestData.generateRandomString(10),
                        List.of("BLACK","GREY"),
                },
                {
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomString(10),
                        TestData.generateRandomNumber(1),
                        TestData.generateRandomDate(),
                        TestData.generateRandomString(10),
                        List.of(),
                },
        };
    }
    @Test
    public void makeOrder(){
        PostApiMakeOrder postApiMakeOrder = new PostApiMakeOrder();
        PostMakeOrderRequestPOJO postMakeOrderRequestPOJO = new PostMakeOrderRequestPOJO(lastName, firstName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        Response response = postApiMakeOrder.makeOrder(postMakeOrderRequestPOJO);
        response.then().statusCode(201).assertThat().body("track", notNullValue());
    }
}
