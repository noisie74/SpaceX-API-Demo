package michael.com.spacex.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import michael.com.spacex.R;
import michael.com.spacex.model.Launch;


/**
 * Adapter object that holds data before displaying to a user
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Launch> upcomingLaunches;

    protected Adapter(List<Launch> upcomingLaunches) {
        setData(upcomingLaunches);
    }

    protected void loadData(List<Launch> upcomingLaunches) {
        setData(upcomingLaunches);
        notifyDataSetChanged();
    }

    private void setData(List<Launch> upcomingLaunches) {
        this.upcomingLaunches = upcomingLaunches;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_launch_content, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Launch launch = upcomingLaunches.get(position);
        holder.flightNumberTV.setText(String.format("Flight number: %s", getFlightNumber(launch)));
        holder.launchYearTV.setText(String.format("Flight year: %s", getLaunchYear(launch)));
        holder.launchDateTV.setText(String.format("Launch date: %s", String.valueOf(formattedLaunchDate(getLaunchDate(launch)))));
        holder.rocketNameTV.setText(String.format("Rocket name: %s", getRocketName(launch)));
        holder.launchSiteTV.setText(String.format("Launch site: %s", getLaunchSite(launch)));
    }

    private String getFlightNumber(Launch launch) {
        return launch.getFlightNumber();
    }

    private String getLaunchYear(Launch launch) {
        return launch.getLaunchYear();
    }

    private long getLaunchDate(Launch launch) {
        return launch.getLaunchDate();
    }

    private Date formattedLaunchDate(long date) {
        return new Date(date * 1000);
    }

    private String getRocketName(Launch launch) {
        return launch.getRocket().getRocketName();
    }

    private String getLaunchSite(Launch launch) {
        return launch.getLaunchSite().getLaunchSiteName();
    }

    @Override
    public int getItemCount() {
        return upcomingLaunches.size();
    }

    /**
     * Class that holds references to the UI components
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView flightNumberTV, launchYearTV, launchDateTV, rocketNameTV, launchSiteTV;

        ViewHolder(View itemView) {
            super(itemView);

            this.flightNumberTV = itemView.findViewById(R.id.flight_number);
            this.launchYearTV = itemView.findViewById(R.id.launch_year);
            this.launchDateTV = itemView.findViewById(R.id.launch_date);
            this.rocketNameTV = itemView.findViewById(R.id.rocket_name);
            this.launchSiteTV = itemView.findViewById(R.id.site_name);
        }
    }
}
