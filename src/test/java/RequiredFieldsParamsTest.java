import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class RequiredFieldsParamsTest {

    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();

    private final String login;
    private final String password;
    private final String firstName;


    public RequiredFieldsParamsTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"", "dsfsdf2131", "dsfsdf2131"},
                {"dsfsdf2131", "", "dsfsdf2131"},
        };
    }

    @Test
    @DisplayName("Проверка заполнения обязательных полей")
    public void checkRequiredFields() {
        postCreateCourierSteps.createCourier(login, password, firstName);
        postCreateCourierSteps.checkResponseNoRequiredFields();
    }
}

