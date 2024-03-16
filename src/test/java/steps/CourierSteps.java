package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import pojo.Courier;
import io.restassured.response.ValidatableResponse;
import static constant.Data.*;

public class CourierSteps {
    @Step("Создание курьера")
    public static ValidatableResponse courierCreate(Courier courier){
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(CREATE_COURIER)
                .then();
    }
    @Step("Логин курьера")
    public static ValidatableResponse courierLogin(Courier courier){
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body(courier)
                .when()
                .post(LOGIN_COURIER)
                .then();
    }
    @Step("Удаление курьера")
    public static ValidatableResponse courierDelete(int id){
        return RestAssured.given()
                .delete(DELETE_COURIER + id)
                .then();
    }
}
