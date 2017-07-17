package sample.app.data.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sample.app.data.BuildConfig;

/**
 * Retrofit interface defining the API method and parameters as constants, allowing for a single place to make
 * changes to the API.
 */
interface FlickrSearchApi {

    String API_BASE = "https://api.flickr.com/services/";
    String API_SEARCH_METHOD = "flickr.photos.search";
    String API_KEY = BuildConfig.FLICKR_API_KEY;
    String API_FORMAT = "json";
    String API_CALLBACK = "1";
    String API_SAFE_SEARCH = "1";

    /**
     * searchImage sends a GET request to the Flickr API that returns an json object containing an array of photo
     * objects
     *
     * @param method method string for flickr's search api
     * @param apiKey flickrs api key
     * @param format data response format
     * @param callback callback object that implements the onSuccess and onFailure methods
     * @param safeSearch a flag for setting safe search on
     * @param text string to be search for
     * @param page current results page being shown
     * @return returns a call object
     */
    @GET("rest/")
    Call<String> searchImage(
            @Query("method") String method, @Query("api_key") String apiKey, @Query("format")
            String format, @Query("nojsoncallback") String callback, @Query("safe_search") String safeSearch, @Query
            ("text") String text, @Query("page") String page);

}
