package sample.app.flickr.search.image;

import sample.app.data.repository.FlickrPhotoRepository;
import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.interactor.SearchPhotoInteractor;
import sample.app.domain.model.FlickrPhoto;

import java.util.List;

import sample.app.flickr.model.PhotoDataMapper;

/**
 * Created by hp on 7/14/2017.
 */

public class SearchPhotoPresenter implements ISearchPhoto.Presenter {

    String searchText = "";
    boolean loadMore = false;
    ISearchPhoto.View view;
    SearchPhotoInteractor searchPhotoInteractor;

    public SearchPhotoPresenter(ISearchPhoto.View view) {
        this.view = view;
        searchPhotoInteractor = new SearchPhotoInteractor(new FlickrPhotoRepository());
    }

    @Override
    public void searchImage(String text) {
        view.showLoading();
        searchText = text;
        loadMore = false;
        searchPhotoInteractor.searchImage(text, "1", new PhotoListCallback());
    }

    @Override
    public void loadMoreImages(String page) {
        loadMore = true;
        searchPhotoInteractor.searchImage(searchText, page, new PhotoListCallback());
    }

    public class PhotoListCallback implements DefaultListener<List<FlickrPhoto>> {

        @Override
        public void onFailure(Throwable exception) {
            view.hideLoading();
            view.showMessage(exception.getMessage());
        }

        @Override
        public void onSuccess(List<FlickrPhoto> flickrPhotos) {
            view.hideLoading();
            view.showImages(new PhotoDataMapper().convertList(flickrPhotos), loadMore);
        }
    }
}
