import SessionsByDistrict.SessionsByDistrictRequest;
import SessionsByDistrict.SessionByDistrictResponse;
import States.StatesResponse;
import districts.DistrictRequest;
import districts.DistrictsResponse;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserClient {


    public static final String baseURI = "https://cdn-api.co-vin.in/api/";

    public StatesResponse getSpecificState(){
       return given()
               .contentType(ContentType.JSON)
               .header("User-Agent", "PostmanRuntime/7.28.0")
               .when()
               .get(baseURI+"v2/admin/location/states").as(StatesResponse.class);
    }

    public DistrictsResponse getDistrictsOfParticularState(DistrictRequest getDistrictRequest){
        return given()
                .contentType(ContentType.JSON)
                .header("User-Agent","PostmanRuntime/7.28.0")
                .when()
                .get(baseURI+"v2/admin/location/districts/"+getDistrictRequest.getId())
                .as(DistrictsResponse.class);
    }


    public SessionByDistrictResponse getSessionsByDistrict(SessionsByDistrictRequest sessionsByDistrictRequest){
        return given().log().all()
                .contentType(ContentType.JSON)
                .header("User-Agent","PostmanRuntime/7.28.0")
                .queryParams("district_id",sessionsByDistrictRequest.getDistrictId())
                .queryParams("date",sessionsByDistrictRequest.getDate())
                .when()
                .get(baseURI+"v2/appointment/sessions/public/findByDistrict")
                .as(SessionByDistrictResponse.class);
    }

}
