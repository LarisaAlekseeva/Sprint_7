package constant;

import java.util.List;

public class Data {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru";
    public static final String LOGIN = "ninjaJai";
    public static final String PASSWORD = "testRam";
    public static final String FIRST_NAME = "Jaymi";

    public static final String EMPTY_LOGIN = "";
    public static final String EMPTY_PASSWORD = "";
    public static final String EMPTY_FIRST_NAME = "";

    public static final String NONEXISTENT_LOGIN = "hello";
    public static final String NONEXISTENT_PASSWORD = "hello";


    public static final String LAST_NAME = "Popov";
    public static final String ADDRESS = "Konoha, 142 apt.";
    public static final int METRO_STATION = 4;
    public static final String PHONE = "+7 800 355 35 35";
    public static final int RENT_TIME = 3;
    public static final String DELIVERY_DATE = "2020-06-06";
    public static final String COMMENT = "privet";
    public static final List<String> COLOUR_BLACK = List.of("BLACK");
    public static final List<String> COLOUR_GREY = List.of("GREY");
    public static final List<String> BLACK_AND_GREY_COLORS = List.of("BLACK","GREY");
    public static final List<String> WITHOUT_COLORS = List.of("");


    public static final String CREATE_COURIER = "/api/v1/courier";
    public static final String DELETE_COURIER = "/api/v1/courier/";
    public static final String LOGIN_COURIER = "/api/v1/courier/login";
    public static final String ORDERS = "/api/v1/orders";
    public static final String CANCEL_ORDER = "/api/v1/orders/cancel";

    public static final String MESSAGE_FOR_INCOMPLETE_REQUEST_LOGIN_COURIER = "Недостаточно данных для входа";
    public static final String MESSAGE_FOR_INCORRECT_REQUEST_LOGIN_COURIER = "Учетная запись не найдена";
    public static final String MESSAGE_FOR_INCOMPLETE_REQUEST_CREATE_COURIER = "Недостаточно данных для создания учетной записи";
    public static final String MESSAGE_FOR_INCORRECT_REQUEST_CREATE_COURIER = "Этот логин уже используется. Попробуйте другой.";
}
