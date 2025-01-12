import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.ResponseSpecification;

import org.junit.jupiter.api.*;

import java.util.HashMap;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PostmanEchoApiTest {
    // Создаем переменные и спецификации для псевдонимов
    String returnText = "This is expected to be sent back as part of response body.";
    ResponseSpecification response200 = expect().statusCode(200);
    ResponseSpecification responseData = expect().body("data", equalTo(returnText));

    @BeforeEach
    public void setupRest() {
        //В каждом тесте указываем главную ссылку и логируем тело и статус ответа для удобства
        RestAssured.baseURI = "https://postman-echo.com/";
        RestAssured.filters(
            new ResponseLoggingFilter(LogDetail.BODY),
            new ResponseLoggingFilter(LogDetail.STATUS)
        );
    }

    // 6 тестов API из PostmanEcho
    @Test
    @Order(1)
    @DisplayName("Запрос GET")
    public void getRequestTest () {
        given()
        .when()
                .get("get?foo1=bar1&foo2=bar2")
        .then()
                .spec(response200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    @Order(2)
    @DisplayName("Запрос POST текста")
    public void postRawTextTest () {
        given()
                .body(returnText)
        .when()
                .post("post")
        .then()
                .spec(response200)
                .spec(responseData);
    }

    @Test
    @Order(3)
    @DisplayName("Запрос POST данных")
    public void postFromDataTest () {
        HashMap<String, String> map = new HashMap<>();
        map.put("foo1", "bar1");
        map.put("foo2", "bar2");
        given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(map)
        .when()
                .post("post")
        .then()
                .spec(response200)
                .body("form", equalTo(map))
                .body("json", equalTo(map));
    }

    @Test
    @Order(4)
    @DisplayName("Запрос PUT")
    public void putRequestTest () {
        given()
                .body(returnText)
        .when()
                .put("put")
        .then()
                .spec(response200)
                .spec(responseData);
    }

    @Test
    @Order(5)
    @DisplayName("Запрос PATCH")
    public void patchRequestTest () {
        given()
                .body(returnText)
        .when()
                .patch("patch")
        .then()
                .spec(response200)
                .spec(responseData);
    }

    @Test
    @Order(6)
    @DisplayName("Запрос DELETE")
    public void deleteRequestTest () {
        given()
                .body(returnText)
        .when()
                .delete("delete")
        .then()
                .spec(response200)
                .spec(responseData);
    }

    //Тесты завершены
}
