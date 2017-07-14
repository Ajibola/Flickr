package android.app.data.network;

import android.app.data.entity.FlickrPhotoEntity;
import android.app.data.entity.mapper.FlickrJsonMapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                .baseUrl(FlickrSearchApi.API_ENDPOINT)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final FlickrSearchApi flickrSearchAPI = retrofit.create(FlickrSearchApi.class);
        Call<String> call = flickrSearchAPI.searchImage(text, page);
        call.enqueue(callback);
    }
}
