import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.iterableWithSize;

public class PostmanEchoApiTest {

    String returnText = "This is expected to be sent back as part of response body.";

    @Test
    @DisplayName("Запрос GET")
    public void getRequestTest () {
        given()
                .baseUri("https://postman-echo.com/")
                .when()
                .get("get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .log().body();
    }

    @Test
    @DisplayName("Запрос POST текста")
    public void postRawTextTest () {
        given()
                .baseUri("https://postman-echo.com/")
                .body(returnText)
                .when()
                .post("post")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnText))
                .log().body();
    }

    @Test
    @DisplayName("Запрос POST данных")
    public void postFromDataTest () {
        HashMap<String, String> map = new HashMap<>();
        map.put("foo1", "bar1");
        map.put("foo2", "bar2");

        given()
                .baseUri("https://postman-echo.com/")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(map)
                .when()
                .post("post")
                .then()
                .statusCode(200)
                .body("form", equalTo(map))
                .body("json", equalTo(map))
                .log().body();
    }

    @Test
    @DisplayName("Запрос PUT")
    public void putRequestTest () {
        given()
                .baseUri("https://postman-echo.com/")
                .body(returnText)
                .when()
                .put("put")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnText))
                .log().body();
    }

    @Test
    @DisplayName("Запрос PATCH")
    public void patchRequestTest () {
        given()
                .baseUri("https://postman-echo.com/")
                .body(returnText)
                .when()
                .patch("patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnText))
                .log().body();
    }

    @Test
    @DisplayName("Запрос DELETE")
    public void deleteRequestTest () {
        given()
                .baseUri("https://postman-echo.com/")
                .body(returnText)
                .when()
                .delete("delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(returnText))
                .log().body();
    }




}
