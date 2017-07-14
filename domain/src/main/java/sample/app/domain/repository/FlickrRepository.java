package sample.app.domain.repository;

import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.model.FlickrPhoto;

import java.util.List;

/**
 * This interface defines the method for searching photos
 */
public interface FlickrRepository {

    void getSearchPhotos(String text, String page, DefaultListener<List<FlickrPhoto>> defaultListener);
}
