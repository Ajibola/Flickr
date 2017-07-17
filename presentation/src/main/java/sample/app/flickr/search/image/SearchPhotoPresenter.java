package sample.app.flickr.search.image;

import sample.app.data.repository.FlickrPhotoRepository;
import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.interactor.SearchPhotoInteractor;
import sample.app.domain.model.FlickrPhoto;

import java.util.List;

import sample.app.flickr.model.PhotoDataMapper;

/**
 * Presenter performs ui changes in the view and also fetches data from the interactor implementation
 */
public class SearchPhotoPresenter implements ISearchPhoto.Presenter {

    private final String FIRST_PAGE = "1";
    private String searchText = "";
    private boolean loadMore = false;
    private final ISearchPhoto.View view;
    private final SearchPhotoInteractor searchPhotoInteractor;

    public SearchPhotoPresenter(ISearchPhoto.View view) {
        this.view = view;
        searchPhotoInteractor = new SearchPhotoInteractor(new FlickrPhotoRepository());
    }

    @Override
    public void searchImage(String text) {
        view.showLoading();
        searchText = text;
        loadMore = false;
        searchPhotoInteractor.searchImage(text, FIRST_PAGE, new PhotoListCallback());
    }

    @Override
    public void loadMoreImages(String page) {
        loadMore = true;
        searchPhotoInteractor.searchImage(searchText, page, new PhotoListCallback());
    }

    /**
     * An implementation of the DefaultListener that defines the generics object as a list of FlickrPhoto objects
     */
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
