package michael.com.spacex.model;

import com.google.gson.annotations.SerializedName;

/**
 * LaunchSite object
 */

public class LaunchSite {

    @SerializedName("site_name_long")
    private String launchSiteName;

    public String getLaunchSiteName() {
        return launchSiteName;
    }

}
