import SessionsByDistrict.SessionsByDistrictRequest;
import SessionsByDistrict.getSessionByDistrictResponse;
import States.getStatesResponse;
import districts.getDistrictRequest;
import districts.getDistrictsResponse;
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

    public getDistrictsResponse getDistrictsOfParticularState(getDistrictRequest getDistrictRequest){
        return given()
                .contentType(ContentType.JSON)
                .header("User-Agent","PostmanRuntime/7.28.0")
                .when()
                .get(baseURI+"v2/admin/location/districts/"+getDistrictRequest.getId())
                .as(getDistrictsResponse.class);
    }


    public getSessionByDistrictResponse getSessionsByDistrict(SessionsByDistrictRequest sessionsByDistrictRequest){
        return given().log().all()
                .contentType(ContentType.JSON)
                .header("User-Agent","PostmanRuntime/7.28.0")
                .queryParams("district_id",sessionsByDistrictRequest.getDistrictId())
                .queryParams("date",sessionsByDistrictRequest.getDate())
                .when()
                .get(baseURI+"v2/appointment/sessions/public/findByDistrict")
                .as(getSessionByDistrictResponse.class);
    }

}
