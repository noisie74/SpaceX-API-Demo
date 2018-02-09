package michael.com.spacex.network;

import java.util.List;

import michael.com.spacex.model.Launch;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API endpoints
 */
public interface Api {

    @GET("upcoming")
    Observable<List<Launch>> getLaunches();

    @GET("launches")
    Observable<List<Launch>> getLaunches(@Query("launch_year") String launchYear);
}
