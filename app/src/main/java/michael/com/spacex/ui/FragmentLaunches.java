package michael.com.spacex.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import michael.com.spacex.R;
import michael.com.spacex.model.Launch;

/**
 * Fragment that displays launches
 */
public class FragmentLaunches extends Fragment implements Contract.View {

    private ProgressBar mProgress;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private TextView mMessageTextView;
    private Adapter mAdapter;
    private Presenter mPresenter;

    public FragmentLaunches() {

    }

    public static FragmentLaunches newInstance() {
        return new FragmentLaunches();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new Adapter(new ArrayList<Launch>());
        mPresenter = new Presenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_launches_layout, container, false);
        initView(rootView);
        setToolBar();
        setRecyclerView();
        mPresenter.loadUpcomingLaunches(true);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
        Log.d("Fragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
        Log.d("Fragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.unSubscribe();
        Log.d("Fragment", "onStop");
    }

    @Override
    public void showUpcomingLaunches(List<Launch> launches) {
        mAdapter.loadData(launches);
    }

    @Override
    public void showFilteredLaunches(List<Launch> launches) {
        mAdapter.loadData(launches);
    }

    @Override
    public void showProgressBar() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeProgressBar() {
        mProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        mMessageTextView.setVisibility(View.VISIBLE);
        mMessageTextView.setText(message);
    }

    @Override
    public void displayRecyclerView(boolean isDisplayed) {
        mRecyclerView.setVisibility(isDisplayed ? View.VISIBLE : View.GONE);
    }

    @Override
    public void hideMessage() {
        mMessageTextView.setVisibility(View.GONE);
    }

    private void initView(View view) {
        mToolbar = getActivity().findViewById(R.id.toolbar);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mProgress = view.findViewById(R.id.progress_bar);
        mMessageTextView = view.findViewById(R.id.no_data_text);
    }

    private void setRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void setToolBar() {
        mToolbar.inflateMenu(R.menu.menu_main);
        setHasOptionsMenu(true);
        mToolbar.setTitle(R.string.app_name);

        //Filter rocket launches by year
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.year_2006:
                        mPresenter.filterLaunches("2006");
                        break;
                    case R.id.year_2007:
                        mPresenter.filterLaunches("2007");
                        break;
                    case R.id.year_2008:
                        mPresenter.filterLaunches("2008");
                        break;
                    case R.id.year_2009:
                        mPresenter.filterLaunches("2009");
                        break;
                    case R.id.year_2010:
                        mPresenter.filterLaunches("2010");
                        break;
                    case R.id.year_2011:
                        mPresenter.filterLaunches("2011");
                        break;
                    case R.id.year_2012:
                        mPresenter.filterLaunches("2012");
                        break;
                    case R.id.year_2013:
                        mPresenter.filterLaunches("2013");
                        break;
                    case R.id.year_2014:
                        mPresenter.filterLaunches("2014");
                        break;
                    case R.id.year_2015:
                        mPresenter.filterLaunches("2015");
                        break;
                    case R.id.year_2016:
                        mPresenter.filterLaunches("2016");
                        break;
                    case R.id.year_2017:
                        mPresenter.filterLaunches("2017");
                        break;
                    case R.id.year_2018:
                        mPresenter.loadUpcomingLaunches(true);
                        break;
                    case R.id.year_2019:
                        mPresenter.filterLaunches("2019");
                        break;
                    case R.id.year_2020:
                        mPresenter.filterLaunches("2020");
                        break;
                }
                return true;
            }
        });
    }
}
