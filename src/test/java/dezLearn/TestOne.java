package dezLearn;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class TestOne {

    @Test(enabled = false)
    public void simpleGetResuest(){

        given()
                .baseUri("https://restcountries.com/v3.1").
        when()
                .get("/all").
        then().
                statusCode(200);

    }

    @Test(enabled = false)
    public void JsonResponseTest(){
        int i =0;
       String subregion = given().
                baseUri("https://restcountries.com/v3.1")
        .when()
                .get("/alpha/USA")
                .then()
                .statusCode(200)
        .body(
                "[0].name.common", equalTo("United States"),
                "[0].cca2", equalTo("US"),
                "[0].independent", equalTo(true),
                "[0].status", equalTo("officially-assigned"),
                "[0].subregion", equalTo("North America")

                )
                .extract().path("[0].subregion");
        System.out.println(subregion);
    }

   @Test(enabled = false)
    public void captureRseponse() {
      Response resp = given()
                .baseUri("https://restcountries.com/v3.1").
        when()
                .get("/alpha/USA").
        then()
                .extract().response();
        System.out.println(resp.asString() );
    }


    @Test(enabled = false)
    public void extractCertainValues(){
   String  startOfWeek =  given()
                .baseUri("https://restcountries.com/v3.1").
        when()
                .get("/alpha/USA").
        then()
                .extract().path("[0].startOfWeek");
        System.out.println(startOfWeek);
    }

    @Test
    public void getStatus(){
        given()
                .baseUri("https://restcountries.com/v3.1/").
        when()
                .get("/all").
        then()
                .statusLine("HTTP/1.1 200 OK");
    }



}
