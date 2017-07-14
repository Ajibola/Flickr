package sample.app.data.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import sample.app.data.network.FlickrSearchApiImpl;
import sample.app.domain.interactor.DefaultListener;
import sample.app.domain.model.FlickrPhoto;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by hp on 7/14/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class FlickrPhotoRepositoryTest {

    private FlickrPhotoRepository flickrPhotoRepository;

    @Mock FlickrSearchApiImpl flickrSearchApi;
    @Mock DefaultListener<List<FlickrPhoto>> defaultListener;

    @Before
    public void setUp() {
        flickrPhotoRepository = new FlickrPhotoRepository();
    }

    @Test
    public void testFlickrPhotoRepository() {
        flickrPhotoRepository.getSearchPhotos("text", "1", defaultListener);
        verifyNoMoreInteractions(flickrSearchApi);
        verifyZeroInteractions(defaultListener);
    }
}
