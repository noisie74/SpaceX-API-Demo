package michael.com.spacex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import michael.com.spacex.ui.FragmentLaunches;

/**
 * Entry point of the Application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a new instance of FragmentLaunches if savedInstanceState is null
        if (savedInstanceState == null)
            initFragment(FragmentLaunches.newInstance());
    }


    /**
     * Adding Fragment to the Activity
     * @param fragment
     */
    private void initFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }
}
