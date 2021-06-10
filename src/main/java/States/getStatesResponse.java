package States;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class getStatesResponse {

    private String ttl;

    private States[] states;

    public String getTtl ()
    {
        return ttl;
    }

    public void setTtl (String ttl)
    {
        this.ttl = ttl;
    }

    public States[] getStates ()
    {
        return states;
    }

    public void setStates (States[] states)
    {
        this.states = states;
    }

}
