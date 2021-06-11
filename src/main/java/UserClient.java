

import SessionsByDistrict.getSessionByDistrictResponse;
import SessionsByDistrict.SessionsByDistrictRequest;
import States.getStatesResponse;
import districts.getDistrictsResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserClient {


    public static final String baseURI = "https://cdn-api.co-vin.in/api/";

    public getStatesResponse getSpecificState(){

       return given()
               .contentType(ContentType.JSON)
               .header("User-Agent", "PostmanRuntime/7.28.0")
               .when()
               .get(baseURI+"v2/admin/location/states").as(getStatesResponse.class);
    }

    public getDistrictsResponse getDistrictsOfParticularState(int id){
        return given()
                .contentType(ContentType.JSON)
                .header("User-Agent","PostmanRuntime/7.28.0")
                .when()
                .get(baseURI+"v2/admin/location/districts/"+id)
                .as(getDistrictsResponse.class);
    }


    public getSessionByDistrictResponse getSessionsByDistrict(SessionsByDistrictRequest sessionsByDistrictRequest){
       // RestAssured.baseURI = "https://cdn-api.co-vin.in/api/";
        return given()
                .contentType(ContentType.JSON)
                .header("User-Agent","PostmanRuntime/7.28.0")
                .queryParams("district_id",sessionsByDistrictRequest.getDistrictId())
                .queryParams("date",sessionsByDistrictRequest.getDate())
                /*.queryParams("district_id","395")
                .queryParams("date","12-06-2021")*/
                .when()
                .get(baseURI+"v2/appointment/sessions/public/findByDistrict")
                .as(getSessionByDistrictResponse.class);
    }

}
