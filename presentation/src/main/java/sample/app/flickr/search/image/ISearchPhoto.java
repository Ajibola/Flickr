package sample.app.flickr.search.image;

import java.util.List;

import sample.app.flickr.model.Photo;

/**
 * Basic contract for presenter and photo search view
 */
public interface ISearchPhoto {

    /**
     * Operations that are implemented in the view and called by the presenter
     */
    interface View {

        void showLoading();

        void hideLoading();

        void showMessage(String message);

        void showImages(List<Photo> photoList, boolean update);
    }

    /**
     * Operations that are implemented in the presenter and called from the view
     */
    interface Presenter {

        void searchImage(String text);

        void loadMoreImages(String page);
    }
}
