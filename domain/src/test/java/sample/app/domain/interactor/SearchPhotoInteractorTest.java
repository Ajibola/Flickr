package sample.app.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import sample.app.domain.repository.FlickrRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Test the Search Photo Interactor
 */

@RunWith(MockitoJUnitRunner.class)
public class SearchPhotoInteractorTest {

    private SearchPhotoInteractor searchPhotoInteractor;

    @Mock
    private FlickrRepository flickrRepository;

    @Before
    public void setUp() {
        searchPhotoInteractor = new SearchPhotoInteractor(flickrRepository);
    }

    @Test
    public void testSearchPhotoInteractorSearchImage() {
        searchPhotoInteractor.searchImage("", "", null);

        verify(flickrRepository).getSearchPhotos("", "", null);
        verifyNoMoreInteractions(flickrRepository);
    }
}
