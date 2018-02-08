package michael.com.spacex.network;

import java.util.List;

import michael.com.spacex.model.Launch;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Mikhail on 2/7/18.
 */

public interface Api {

    @GET("upcoming")
    Observable<List<Launch>> getLaunches();

    @GET("launches")
    Observable<List<Launch>> getLaunches(@Query("launch_year") String launchYear);
}
