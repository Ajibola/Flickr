package sample.app.flickr.search.image;

import java.util.List;

import sample.app.flickr.model.Photo;
import sample.app.flickr.search.BaseView;

/**
 * Basic contract for presenter and photo search view
 */
public interface ISearchPhoto {

    interface View extends BaseView {

        void showImages(List<Photo> photoList, boolean update);
    }

    interface Presenter {

        void searchImage(String text);

        void loadMoreImages(String page);
    }
}
