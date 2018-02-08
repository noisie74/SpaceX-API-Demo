package michael.com.spacex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mikhail on 2/7/18.
 */

public class LaunchSite {

    @SerializedName("site_name_long")
    private String launchSiteName;

    public String getLaunchSiteName() {
        return launchSiteName;
    }

}
