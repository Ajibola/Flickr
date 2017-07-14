package android.app.domain.interactor;

import android.app.domain.model.FlickrPhoto;
import android.app.domain.repository.FlickrRepository;

import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public class SearchPhotoInteractor {

    private FlickrRepository flickrRepository;

    public SearchPhotoInteractor(FlickrRepository flickrRepository) {
        this.flickrRepository = flickrRepository;
    }

    public void searchImage(String text, String page, DefaultListener<List<FlickrPhoto>> defaultListener) {
        flickrRepository.getSearchPhotos(text, page, defaultListener);
    }
}