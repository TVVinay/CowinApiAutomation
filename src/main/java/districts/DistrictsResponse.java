package districts;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictsResponse {

    private Districts[] districts;

    private String ttl;

}
