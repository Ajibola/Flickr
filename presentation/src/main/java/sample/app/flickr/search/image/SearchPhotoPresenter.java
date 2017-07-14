package sample.app.flickr.search.image;


import android.app.data.repository.FlickrPhotoRepository;
import android.app.domain.interactor.DefaultListener;
import android.app.domain.interactor.SearchPhotoInteractor;
import android.app.domain.model.FlickrPhoto;

import java.util.ArrayList;
import java.util.List;

import sample.app.flickr.model.Photo;

/**
 * Created by hp on 7/14/2017.
 */

public class SearchPhotoPresenter implements ISearchPhoto.Presenter {

    ISearchPhoto.View view;
    SearchPhotoInteractor searchPhotoInteractor;

    public SearchPhotoPresenter(ISearchPhoto.View view) {
        this.view = view;
        searchPhotoInteractor = new SearchPhotoInteractor(new FlickrPhotoRepository());
    }

    @Override
    public void searchImage(String text, String page) {
        view.showLoading();

        searchPhotoInteractor.searchImage(text, page, new PhotoListCallback());

    }

    @Override
    public void loadImages(List<Photo> photos) {
        view.hideLoading();
        view.showImages(photos);
    }

    public class PhotoListCallback implements DefaultListener<List<FlickrPhoto>> {

        @Override
        public void onFailure(Throwable exception) {
            view.showMessage(exception.getMessage());
        }

        @Override
        public void onSuccess(List<FlickrPhoto> flickrPhotos) {

        }
    }
}
