package android.app.data.network;

import android.app.data.entity.FlickrPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hp on 7/14/2017.
 */

public interface FlickrImageSearch {

    public static final String API_ENDPOINT = "https://api.flickr.com/services/rest/";

    @GET("method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1&safe_search=1&")
    Call<List<FlickrPhoto>> searchImage(@Query("text") String text, @Query("page") String page);

}
