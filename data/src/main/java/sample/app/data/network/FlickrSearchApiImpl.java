package sample.app.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by hp on 7/14/2017.
 */

public class FlickrSearchApiImpl {

    public void searchImage(String text, String page, Callback<String> callback) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);

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
