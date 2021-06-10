package districts;

public class getDistrictsResponse {

    private Districts[] districts;

    private String ttl;

    public Districts[] getDistricts ()
    {
        return districts;
    }

    public void setDistricts (Districts[] districts)
    {
        this.districts = districts;
    }

    public String getTtl ()
    {
        return ttl;
    }

    public void setTtl (String ttl)
    {
        this.ttl = ttl;
    }
}
