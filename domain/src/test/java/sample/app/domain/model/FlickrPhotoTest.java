package sample.app.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the data object
 */
public class FlickrPhotoTest {

    private static final String IMAGE_TITLE = "image";
    private FlickrPhoto flickrPhoto;

    @Before
    public void setUp() {
        flickrPhoto = new FlickrPhoto(IMAGE_TITLE, "http://google.com");
    }

    @Test
    public void testDomainModelFlickrPhoto() {
        assertEquals(flickrPhoto.getTitle(), IMAGE_TITLE);
    }
}
