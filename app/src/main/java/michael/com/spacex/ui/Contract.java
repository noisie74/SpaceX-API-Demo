package michael.com.spacex.ui;

import java.util.List;

import michael.com.spacex.model.Launch;

/**
 * Contract between View and Presenter
 */

public interface Contract {

    interface View {

        void showUpcomingLaunches(List<Launch> launches);

        void showFilteredLaunches(List<Launch> launches);

        void displayRecyclerView(boolean isDisplayed);

        void showProgressBar();

        void removeProgressBar();

        void showMessage(String message);

        void hideMessage();

    }

    interface Presenter {

        void loadUpcomingLaunches(boolean isLoading);

        void filterLaunches(String launchYear);

        void subscribe();

        void unSubscribe();

    }

}
