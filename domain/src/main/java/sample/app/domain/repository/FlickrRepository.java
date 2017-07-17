package sample.app.domain.repository;

import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.model.FlickrPhoto;

import java.util.List;

/**
 * This interface defines the method for searching photos
 */
public interface FlickrRepository {

    /**
     * Defines the access mechanism and required parameters for getting search photos to be implemented by inheriting
     * classes
     *
     * @param text the search string
     * @param page the page currently displayed from the results
     * @param defaultListener a listener that executes necessary operations onSuccess or onFailure of the request
     */
    void getSearchPhotos(String text, String page, DefaultListener<List<FlickrPhoto>> defaultListener);
}
