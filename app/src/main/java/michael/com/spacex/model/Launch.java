package michael.com.spacex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mikhail on 2/7/18.
 */

public class Launch {

    @SerializedName("flight_number")
    private String flightNumber;
    @SerializedName("launch_year")
    private String launchYear;
    @SerializedName("launch_date_unix")
    private long launchDate;
    private Rocket rocket;
    @SerializedName("launch_site")
    private LaunchSite launchSite;

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public long getLaunchDate() {
        return launchDate;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }
}
