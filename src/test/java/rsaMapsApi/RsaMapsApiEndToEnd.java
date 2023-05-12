package rsaMapsApi;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import  io.restassured.RestAssured.*;
import pojo.AddPlacePayload;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;



public class RsaMapsApiEndToEnd {

    String placeID;
    AddPlacePayload addPlace = new AddPlacePayload();

    @Test(priority = 0)
    public  void postDataToMapAPI(){
    //    File MapsPostReqPayLoad = new File("Resources/MapsPostPayLoad");
         placeID = given()
                .baseUri("https://rahulshettyacademy.com")
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(PayLoad.AddPlacePostRequest()).
        when()
                .post("/maps/api/place/add/json").
         then()
                .statusCode(200).extract().path("place_id");
        System.out.println("PlaceID "+ placeID);
        System.out.println("post Data To MapAPI Executed \n" );
    }


    @Test(priority = 1)
    public  void getDataFromMapAPI() {
        if (placeID != null) {
            given()
                    .baseUri("https://rahulshettyacademy.com")
                    .queryParam("place_id", placeID)
                    .queryParam("key", "qaclick123").
                    when()
                    .get("/maps/api/place/get/json").
                    then()
                    .statusCode(200).log().all();
            System.out.println("get Data From MapAPI Executed \n");
        }
    }

    @Test(priority = 2)
    public void putDataToMapAPI (){
        given()
                .baseUri("https://rahulshettyacademy.com")
                .queryParam("place_id", placeID)
                .queryParam("key","qaclick123")
                .body("{\n" +
                        "\"place_id\":\""+placeID+"\",\n" +
                        "\"address\":\"Chinkul Street\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").
        when()
                .put("/maps/api/place/update/json").
        then()
                .statusCode(200).log().all();
        System.out.println("put Data To MapAPI Executed \n");
    }



    @Test(priority = 3)
    public  void getAgainDataFromMapAPI() {
        if (placeID != null) {
            given()
                    .baseUri("https://rahulshettyacademy.com")
                    .queryParam("place_id", placeID)
                    .queryParam("key", "qaclick123").
                    when()
                    .get("/maps/api/place/get/json").
                    then()
                    .statusCode(200).log().all();
            System.out.println("get Data From MapAPI Executed \n");
        }
    }

    @Test(priority = 4)
    public void deleteDatafromMapAPI(){
        given()
                .baseUri("https://rahulshettyacademy.com")
                .queryParam("key", "qaclick123")
                .body("{\n" +
                        "    \"place_id\":\""+placeID+"\"\n" +
                        "}\n").
        when()
                .delete("/maps/api/place/delete/json").
        then()
                .statusCode(200).log().all();
        System.out.println("DELETE From MapAPI Executed \n");
    }

    @Test(priority = 5)
    public  void AgainDataFromMapAPI() {
        if (placeID != null) {
            given()
                    .baseUri("https://rahulshettyacademy.com")
                    .queryParam("place_id", placeID)
                    .queryParam("key", "qaclick123").
                    when()
                    .get("/maps/api/place/get/json").
                    then()
                    .statusCode(404) .log().all();
            System.out.println("LAST Data From MapAPI Executed \n");
        }
    }



}

