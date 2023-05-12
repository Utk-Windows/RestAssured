package dezLearn;

import io.restassured.RestAssured;
import org.testng.FileAssert;
import org.testng.annotations.Test;

import java.io.File;
import  io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.annotations.Test;




public class PostRequests {

    @Test
    public void postData(){
         File file = new File("Resources/MapsPostPayLoad");
       String pID =  given()
                .baseUri("https://rahulshettyacademy.com")
                .queryParam("key ","qaclick123")
                .header("Content-Type", "application/json")
                        .body(file).
        when()
                .post("/maps/api/place/add/json").
        then()
                .statusCode(200)
                .body("status", equalTo("OK"))
                .extract().path("place_id");
        System.out.println(pID);
    }
/*    public void RSAMethod(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given()
                .queryParam("key ","qaclick123").
               header()
    }*/






}
