package sample.app.flickr.search.image;

import java.util.List;

import sample.app.flickr.model.Photo;
import sample.app.flickr.search.BaseView;

/**
 * Created by hp on 7/14/2017.
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
