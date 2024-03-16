import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import steps.CourierSteps;
import steps.OrderSteps;
import static constant.Data.BASE_URL;

public class BaseTest {
    protected Integer courierId;
    protected Integer track;

    @Before
    public void setUpURL() {
        RestAssured.baseURI = BASE_URL;
    }
    @After
    public void clearData() {
        if (courierId != null) {
            CourierSteps.courierDelete(courierId);
        }
        if (track != null) {
            OrderSteps.cancelOrder(track);
        }
    }
}

