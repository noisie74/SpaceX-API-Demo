package michael.com.spacex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mikhail on 2/7/18.
 */

public class Rocket {

    @SerializedName("rocket_name")
    private String rocketName;

    public String getRocketName() {
        return rocketName;
    }

}
