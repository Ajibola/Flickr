package sample.app.domain.repository;

import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.model.FlickrPhoto;

import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public interface FlickrRepository {

    void getSearchPhotos(String text, String page, DefaultListener<List<FlickrPhoto>> defaultListener);
}
