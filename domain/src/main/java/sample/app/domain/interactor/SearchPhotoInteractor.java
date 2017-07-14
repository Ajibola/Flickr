package sample.app.domain.interactor;

import sample.app.domain.model.FlickrPhoto;
import sample.app.domain.repository.FlickrRepository;

import java.util.List;

/**
 * The interactor defines the use case for searching photos from the view
 */
public class SearchPhotoInteractor {

    private final FlickrRepository flickrRepository;

    public SearchPhotoInteractor(FlickrRepository flickrRepository) {
        this.flickrRepository = flickrRepository;
    }

    public void searchImage(String text, String page, DefaultListener<List<FlickrPhoto>> defaultListener) {
        flickrRepository.getSearchPhotos(text, page, defaultListener);
    }
}
