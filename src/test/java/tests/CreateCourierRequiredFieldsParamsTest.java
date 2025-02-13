package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.PostCreateCourierSteps;
import testData.TestData;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class CreateCourierRequiredFieldsParamsTest {


    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();

    private final String login;
    private final String password;
    private final String firstName;


    public CreateCourierRequiredFieldsParamsTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"", TestData.generateRandomString(10), TestData.generateRandomString(10)},
                {TestData.generateRandomString(10), "", TestData.generateRandomString(10)},
        };
    }

    @Test
    @DisplayName("Проверка заполнения обязательных полей")
    public void checkRequiredFields() {
        postCreateCourierSteps.createCourier(login, password, firstName);
        postCreateCourierSteps.checkResponseNoRequiredFields();
    }
}

