package SessionsByDistrict;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class getSessionByDistrictResponse {


    private Sessions[] sessions;


    public Sessions[] getSessions ()
    {
        return sessions;
    }

    public void setSessions (Sessions[] sessions)
    {
        this.sessions = sessions;
    }
}
