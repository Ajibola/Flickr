package sample.app.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import sample.app.domain.repository.FlickrRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Test the Search Photo Interactor
 */

@RunWith(MockitoJUnitRunner.class)
public class SearchPhotoInteractorTest {

    private SearchPhotoInteractor searchPhotoInteractor;

    @Mock
    private FlickrRepository flickrRepository;
    @Mock
    private DefaultListener defaultListener;

    @Before
    public void setUp() {
        searchPhotoInteractor = new SearchPhotoInteractor(flickrRepository);
    }

    @Test
    public void testSearchPhotoInteractor_SearchImage() {
        searchPhotoInteractor.searchImage("", "", defaultListener);

        verify(flickrRepository).getSearchPhotos("", "", defaultListener);
        verifyNoMoreInteractions(flickrRepository);
        verifyZeroInteractions(defaultListener);
    }
}
