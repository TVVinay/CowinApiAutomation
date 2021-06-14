import SessionsByDistrict.Sessions;
import SessionsByDistrict.SessionsByDistrictRequest;
import SessionsByDistrict.SessionByDistrictResponse;
import States.States;
import districts.Districts;
import districts.DistrictRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        DistrictRequest getDistrictRequest = new DistrictRequest();
        getDistrictRequest.setId(21);
        String distId = null;
        Districts[] districts = userClient.getDistrictsOfParticularState(getDistrictRequest).getDistricts();
        for(Districts districts1 :districts) {
            if(districts1.getDistrict_name().equalsIgnoreCase("Mumbai"))
               distId = districts1.getDistrict_id();
        }

        System.out.println("District Id is "+distId);
        Assert.assertEquals(distId,"395");
    }

    @Test
    public void getVaccinesCountForDistrict(){
        LocalDate date = LocalDate.now().plusDays(1);
        String nextDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(nextDate);
        SessionsByDistrictRequest sessionsByDistrictRequest = new SessionsByDistrictRequest();
        sessionsByDistrictRequest.setDistrictId("395");
        sessionsByDistrictRequest.setDate(nextDate);

       SessionByDistrictResponse sessionByDistrictResponse = userClient
               .getSessionsByDistrict(sessionsByDistrictRequest);
        Sessions[] sessions = sessionByDistrictResponse.getSessions();
        int CoviCount = 0;
        int CovaCount = 0;
        for (Sessions session : sessions){
          if(session.getVaccine().equalsIgnoreCase("COVISHIELD"))
              CoviCount++;
          else
              CovaCount++;
      }

        System.out.println("Total Number of Covishield for the "+nextDate+" is "+CoviCount);
        System.out.println("Total Number of Covaxin for the "+nextDate+" is "+CovaCount);
    }

}
