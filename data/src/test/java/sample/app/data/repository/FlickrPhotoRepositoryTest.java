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
 * Unit tests for the repository implementation
 */
@RunWith(MockitoJUnitRunner.class)
public class FlickrPhotoRepositoryTest {

    private FlickrPhotoRepository flickrPhotoRepository;

    @Mock private DefaultListener<List<FlickrPhoto>> defaultListener;
    @Mock private FlickrSearchApiImpl flickrSearchApi;

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
