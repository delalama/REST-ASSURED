package assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class assuredTests {

    private final String name = "Jesús de la Lama Amengual";
    private final String empId = "33.44.12";
    private final String endPoint = "/add/employee?";
    private final String nameParam = "name=";
    private final String empIdParam = "&empId=";
    private final String fullUri = endPoint + nameParam + name + empIdParam + empId;

    @Test
    public void givenUrl_whenGetEmployee_thenCorrect() {
        get(fullUri).then().statusCode(200).assertThat()
                .body("name", equalTo(name));
    }

    @Test
    public void whenMeasureResponseTime_thenOK() {
        Response response = RestAssured.get(fullUri);
        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);

        assertEquals(timeInS, timeInMS/1000);
    }

    @Test
    public void whenLogRequest_thenOK() {
        given().log().all()
                .when().get(fullUri)
                .then().statusCode(200);
    }

    @Test
    public void whenLogResponse_thenOK() {
        when().get(fullUri)
                .then().log().body().statusCode(200);
    }
}
