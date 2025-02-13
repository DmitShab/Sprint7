package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.DeleteCourierSteps;
import steps.PostCreateCourierSteps;

public class DeleteCourierTest {
    DeleteCourierSteps deleteCourierSteps = new DeleteCourierSteps();
    PostCreateCourierSteps postCreateCourierSteps = new PostCreateCourierSteps();

    @Test
    @DisplayName("Проверка удаления курьера при валидном запросе")
    public void deleteCourier() {
        postCreateCourierSteps.createCourier();
        deleteCourierSteps.deleteCourier();
    }

    @Test
    @DisplayName("Проверка удаления, не передав id")
    public void deleteCourierNoId() {
        deleteCourierSteps.deleteCourierNoId();
    }
    @Test
    @DisplayName("Проверка удаления, передав несуществующий id")
    public void deleteCourierWrongId(){
        deleteCourierSteps.deleteCourierWrongId();
    }
}
