package SessionsByDistrict;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sessions {
    private String date;

    private String pincode;

    private String address;

    private String min_age_limit;

    private String fee;

    private String session_id;

    private String fee_type;

    private String available_capacity;

    private String long1;

    private String district_name;

    private String block_name;

    private String vaccine;

    private String[] slots;

    private String center_id;

    private String state_name;

    private String name;

    private String from;

    private String to;

    private String available_capacity_dose2;

    private String lat;

    private String available_capacity_dose1;
}
