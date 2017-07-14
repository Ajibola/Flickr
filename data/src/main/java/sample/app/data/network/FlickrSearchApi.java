package sample.app.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit interface defining the API methods, constants and variables
 */
interface FlickrSearchApi {

    String API_BASE = "https://api.flickr.com/services/";
    String API_SEARCH_METHOD = "flickr.photos.search";
    String API_KEY = "3e7cc266ae2b0e0d78e279ce8e361736";
    String API_FORMAT = "json";
    String API_CALLBACK = "1";
    String API_SAFE_SEARCH = "1";

    @GET("rest/")
    Call<String> searchImage(
            @Query("method") String method, @Query("api_key") String api_key, @Query("format")
            String format, @Query("nojsoncallback") String callback, @Query("safe_search") String safeSearch, @Query
            ("text") String text, @Query("page") String page);

}
