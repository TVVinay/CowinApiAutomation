import SessionsByDistrict.getSessionByDistrictResponse;
import SessionsByDistrict.Sessions;
import SessionsByDistrict.SessionsByDistrictRequest;
import States.States;
import districts.Districts;
import districts.getDistrictRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

public class CowinApiTest {

    UserClient userClient;
    @BeforeTest
    public void initialize(){
      userClient = new UserClient();
    }

    @Test
    public void getSpecificState(){
        States[] states =userClient.getSpecificState().getStates();
        for (States s :states) {
           if(s.getState_name().equalsIgnoreCase("Maharashtra"))
               s.setState_id(s.getState_id());
        }
    }

    @Test
    public void getDistrictOfSelectedState(){
        getDistrictRequest getDistrictRequest = new getDistrictRequest();
        getDistrictRequest.setId(21);
        String distId = null;
        Districts[] districts = userClient.getDistrictsOfParticularState(getDistrictRequest.getId()).getDistricts();
        for(Districts districts1 :districts) {
            if(districts1.getDistrict_name().equalsIgnoreCase("Mumbai"))
               distId = districts1.getDistrict_id();
        }
        Assert.assertEquals(distId,"395");
    }

    @Test
    public void getSessionsByDistrict(){
        LocalDate date = LocalDate.now().plusDays(1);
        String nextDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(nextDate);
        SessionsByDistrictRequest sessionsByDistrictRequest = new SessionsByDistrictRequest();
        sessionsByDistrictRequest.setDistrictId("395");
        sessionsByDistrictRequest.setDate(nextDate);

       getSessionByDistrictResponse sessionByDistrictResponse = userClient.getSessionsByDistrict(sessionsByDistrictRequest);
      Sessions[] sessions = sessionByDistrictResponse.getSessions();
      for (Sessions session : sessions){
          System.out.println(session.getVaccine());
      }
    }

}
