package michael.com.spacex.ui;

import android.util.Log;

import java.util.List;

import michael.com.spacex.model.Launch;
import michael.com.spacex.network.ApiService;
import michael.com.spacex.util.Constants;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Class responsible for querying the model and updating the view, reacting to user interactions
 */
public class Presenter implements Contract.Presenter {

    private CompositeSubscription mSubscription;
    private Contract.View mView;

    protected Presenter(Contract.View view) {
        this.mView = view;
        this.mSubscription = new CompositeSubscription();
    }

    @Override
    public void loadUpcomingLaunches(boolean isLoading) {
        if (isLoading) {
            mView.showProgressBar();
            getLaunches();
        }
    }

    private void getLaunches() {
        mSubscription.add(ApiService.networkCall(Constants.URL_UPCOMING).getLaunches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Launch>>() {
                    @Override
                    public void onCompleted() {
                        mView.removeProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Presenter", e.getMessage());
                        mView.showMessage("Unable to load upcoming launches");
                        mView.removeProgressBar();
                    }

                    @Override
                    public void onNext(List<Launch> launchResponse) {
                        if (launchResponse != null) {
                            mView.displayRecyclerView(true);
                            mView.hideMessage();
                            mView.showUpcomingLaunches(launchResponse);
                        } else {
                            mView.displayRecyclerView(false);
                            mView.showMessage("Unable to load upcoming launches");
                            mView.removeProgressBar();
                        }
                    }

                }));

    }

    @Override
    public void filterLaunches(String launchYear) {
        mView.showProgressBar();
        mSubscription.add(ApiService.networkCall(Constants.URL_ALL).getLaunches(launchYear)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Launch>>() {
                    @Override
                    public void onCompleted() {
                        mView.removeProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Presenter", e.getMessage());
                        mView.showMessage("Unable to load launches");
                        mView.removeProgressBar();
                    }

                    @Override
                    public void onNext(List<Launch> launchResponse) {
                        if (launchResponse != null && launchResponse.size() > 0) {
                            mView.displayRecyclerView(true);
                            mView.hideMessage();
                            mView.showFilteredLaunches(launchResponse);
                        } else {
                            mView.displayRecyclerView(false);
                            mView.showMessage("No launches found");
                            mView.removeProgressBar();
                        }
                    }

                }));
    }

    @Override
    public void subscribe() {
        loadUpcomingLaunches(false);
    }

    @Override
    public void unSubscribe() {
        mSubscription.clear(); //clear Subscription object
    }
}
