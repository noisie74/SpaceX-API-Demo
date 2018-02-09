package michael.com.spacex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Rocket object
 */

public class Rocket {

    @SerializedName("rocket_name")
    private String rocketName;

    public String getRocketName() {
        return rocketName;
    }

}
