package helpers;

import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {
    static DeviceConfig config = ConfigFactory.create(DeviceConfig.class, System.getProperties());


    public static String videoUrl(String sessionId) {
        given()
                .auth().basic(config.userLogin(), config.userKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");


        return sessionId;
    }
}
