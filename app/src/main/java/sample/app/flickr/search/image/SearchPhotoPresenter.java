package sample.app.flickr.search.image;


import java.util.ArrayList;
import java.util.List;

import sample.app.flickr.model.Photo;

/**
 * Created by hp on 7/14/2017.
 */

public class SearchPhotoPresenter implements ISearchPhoto.Presenter {

    ISearchPhoto.View view;

    public SearchPhotoPresenter(ISearchPhoto.View view) {
        this.view = view;
    }

    @Override
    public void searchImage(String imageText, String page) {
        view.showLoading();

    }

    @Override
    public void loadImages(List<Photo> photos) {
        view.hideLoading();
        view.showImages(photos);
    }

}
