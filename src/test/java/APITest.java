import static io.restassured.RestAssured.*;
import io.restassured.specification.*;
import io.restassured.builder.*;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;


public class APITest {

    private static final String BASE_URI = "https://postman-echo.com";
    private static final String RESPONSE = "This is expected to be sent back as part of response body.";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeEach
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void getRequestTest() {
        given()
                .spec(requestSpecification)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .spec(responseSpecification)
                .log().all()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawTextTest() {
        given()
                .spec(requestSpecification)
                .body("")
                .when()
                .post("/post")
                .then()
                .spec(responseSpecification)
                .log().all()
                .body("json", equalTo(null));
    }

    @Test
    public void postFormDataTest() {
        given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .spec(responseSpecification)
                .log().all()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putRequestTest() {
        given()
                .spec(requestSpecification)
                .body(RESPONSE)
                .when()
                .put("/put")
                .then()
                .spec(responseSpecification)
                .log().all()
                .body("data", equalTo(RESPONSE));
    }

    @Test
    public void patchRequestTest() {
        given()
                .spec(requestSpecification)
                .body(RESPONSE)
                .when()
                .patch("/patch")
                .then()
                .spec(responseSpecification)
                .log().all()
                .body("data", equalTo(RESPONSE));
    }

    @Test
    public void deleteRequestTest() {
        given()
                .spec(requestSpecification)
                .when()
                .delete("/delete")
                .then()
                .spec(responseSpecification)
                .log().all()
                .body("json", nullValue())
                .body("url", equalTo(BASE_URI + "/delete"));
    }
}