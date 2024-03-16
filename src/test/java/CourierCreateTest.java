import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pojo.Courier;
import steps.CourierSteps;
import static constant.Data.*;
import static org.hamcrest.Matchers.equalTo;

public class CourierCreateTest extends BaseTest {
    @Test
    @DisplayName("Создание курьера")
    public void createCourierTest() {
        Courier courier = new Courier(LOGIN, PASSWORD, FIRST_NAME);
        ValidatableResponse response = CourierSteps.courierCreate(courier);
        courierId = CourierSteps.courierLogin(courier).extract().path("id");
        response.assertThat().body("ok", equalTo(true)).and().statusCode(201);
    }
    @Test
    @DisplayName("Создание еще одного курьера с таким же логином")
    public void createDuplicateCourierTest() {
        Courier courier = new Courier(LOGIN, PASSWORD, FIRST_NAME);
        CourierSteps.courierCreate(courier);
        ValidatableResponse responseDuplicate = CourierSteps.courierCreate(courier);
        courierId = CourierSteps.courierLogin(courier).extract().path("id");
        responseDuplicate.assertThat().body("message", equalTo(MESSAGE_FOR_INCORRECT_REQUEST_CREATE_COURIER)).statusCode(409);
    }
    @Test
    @DisplayName("Создание курьера с отсутствием данных в логине")
    public void createCourierWithoutLoginTest() {
        Courier courierWithoutLogin = new Courier(EMPTY_LOGIN, PASSWORD, FIRST_NAME);
        ValidatableResponse response = CourierSteps.courierCreate(courierWithoutLogin);
        response.assertThat().body("message", equalTo(MESSAGE_FOR_INCOMPLETE_REQUEST_CREATE_COURIER)).statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера с отсутствием данных в пароле")
    public void createCourierWithoutPasswordTest() {
        Courier courierWithoutPassword = new Courier(LOGIN, EMPTY_PASSWORD, FIRST_NAME);
        ValidatableResponse response = CourierSteps.courierCreate(courierWithoutPassword);
        response.assertThat().body("message", equalTo(MESSAGE_FOR_INCOMPLETE_REQUEST_CREATE_COURIER)).statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера с отсутствием данных в имени")
    public void createCourierWithoutNameTest() {
        Courier courierWithoutName = new Courier(LOGIN, PASSWORD, EMPTY_FIRST_NAME);
        ValidatableResponse response = CourierSteps.courierCreate(courierWithoutName);
        courierId = CourierSteps.courierLogin(courierWithoutName).extract().path("id");
        response.assertThat().body("ok", equalTo(true)).and().statusCode(201);
    }
}
