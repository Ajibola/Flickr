package sample.app.data.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Flickr API response object
 */

public class FlickrPhotoEntityTest {

    private static final String IMAGE_TITLE = "image";
    private FlickrPhotoEntity flickrPhotoEntity;

    @Before
    public void setUp() {
        flickrPhotoEntity = new FlickrPhotoEntity();
        flickrPhotoEntity.setTitle("first");
        flickrPhotoEntity.setFarm(5);
        flickrPhotoEntity.setId("234234");
        flickrPhotoEntity.setSecret("secret");
    }

    @Test
    public void testDataModel_FlickrPhotoEntity() {
        assertEquals(flickrPhotoEntity.getTitle(), "first");
        assertEquals(flickrPhotoEntity.getFarm(), 5);
    }
}
