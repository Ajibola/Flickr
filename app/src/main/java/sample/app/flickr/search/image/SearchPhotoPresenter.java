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
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("http://farm5.static.flickr.com/4210/35849005346_8a31e516ec.jpg", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));
        photos.add(new Photo("https://s.yimg.com/pw/images/en-us/photo_unavailable.png", "Blank"));

        loadImages(photos);
    }

    @Override
    public void loadImages(List<Photo> photos) {
        view.hideLoading();
        view.showImages(photos);
    }

}
