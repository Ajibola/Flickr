package sample.app.data.network;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Implementation of the search API
 */
public class FlickrSearchApiImpl {

    /**
     * searchImage creates a http client instance and calls the api method with the callback instance supplied in the
     * parameter
     *
     * @param text the string to be searched
     * @param page the page of results to be returned. Each page returns a maximum of 100 results
     * @param callback returns the string value if successful or an error message if not
     */
    public void searchImage(String text, String page, Callback<String> callback) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FlickrSearchApi.API_BASE)
                .client(httpClient.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        final FlickrSearchApi flickrSearchAPI = retrofit.create(FlickrSearchApi.class);
        Call<String> call = flickrSearchAPI.searchImage(FlickrSearchApi.API_SEARCH_METHOD, FlickrSearchApi.API_KEY,
                FlickrSearchApi.API_FORMAT, FlickrSearchApi.API_CALLBACK, FlickrSearchApi.API_SAFE_SEARCH, text, page);
        call.enqueue(callback);
    }
}
