package sample.app.data.repository;

import sample.app.data.entity.FlickrPhotoEntity;
import sample.app.data.entity.mapper.FlickrDataMapper;
import sample.app.data.entity.mapper.FlickrJsonMapper;
import sample.app.data.network.FlickrSearchApiImpl;
import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.model.FlickrPhoto;
import sample.app.domain.repository.FlickrRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 7/14/2017.
 */

public class FlickrPhotoRepository implements FlickrRepository {

    @Override
    public void getSearchPhotos(String text, String page, final DefaultListener<List<FlickrPhoto>> defaultListener) {
        FlickrSearchApiImpl flickrSearchApi = new FlickrSearchApiImpl();
        Callback<String> callback = new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String responseStr = response.body();
                if (responseStr != null) {
                    List<FlickrPhotoEntity> flickrPhotoEntities = new FlickrJsonMapper().parseFlickrResponse(
                            responseStr);
                    defaultListener.onSuccess(new FlickrDataMapper().convertList(flickrPhotoEntities));
                } else {
                    defaultListener.onFailure(new Exception("Unable to load images"));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                defaultListener.onFailure(new Exception("Unable to load images"));
            }
        };
        flickrSearchApi.searchImage(text, page, callback);
    }
}
