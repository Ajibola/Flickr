package sample.app.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hp on 7/14/2017.
 */

public class FlickrPhotoTest {

    private static final String IMAGE_TITLE = "image";
    private FlickrPhoto flickrPhoto;

    @Before
    public void setUp() {
        flickrPhoto = new FlickrPhoto(IMAGE_TITLE, "http://google.com");
    }

    @Test
    public void testDomainModel_FlickrPhoto() {
        assertEquals(flickrPhoto.getTitle(), IMAGE_TITLE);
    }
}
