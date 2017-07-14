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

    public static final String API_BASE = "https://api.flickr.com/services/rest/?";
    public static final String API_METHOD = "method=flickr.photos.search&";
    public static final String API_KEY = "api_key=3e7cc266ae2b0e0d78e279ce8e361736&";
    public static final String API_FORMAT = "format=json&nojsoncallback=1&safe_search=1&";
    public static final String API_ENDPOINT = API_BASE + API_METHOD + API_KEY + API_FORMAT;

    @GET("")
    Call<List<FlickrPhoto>> searchImage(@Query("text") String text, @Query("page") String page);

}
