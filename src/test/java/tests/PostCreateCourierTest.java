package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import steps.DeleteCourierSteps;
import steps.PostCreateCourierSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class PostCreateCourierTest {

    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();
    DeleteCourierSteps deleteCourierSteps = new DeleteCourierSteps();

    @After
    public void deleteTestUsers() {
        deleteCourierSteps.deleteCourier();
    }

    @Test
    @DisplayName("Создание курьера")
    public void postCreateCourierTest() {
        postCreateCourierSteps.createCourier();
        postCreateCourierSteps.checkResponseBodyPos();
    }

    @Test
    @DisplayName("Содание двух одинаковых курьеров")
    public void postCreateTwoSameCouriers() {
        postCreateCourierSteps.createCourier();
        postCreateCourierSteps.createCourierDouble();
        postCreateCourierSteps.checkResponseBodyNeg();
    }

}
