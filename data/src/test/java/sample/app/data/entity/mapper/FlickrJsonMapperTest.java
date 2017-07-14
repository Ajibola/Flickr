package sample.app.data.entity.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import sample.app.data.TestUtil;
import sample.app.data.entity.FlickrPhotoEntity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Test JSON entity mapper
 */

@RunWith(RobolectricTestRunner.class)
public class FlickrJsonMapperTest {

    private static String JSON_RESPONSE_FLICKR_PHOTO;
    private static String JSON_RESPONSE_FLICKR_PHOTO_LIST;
    private FlickrJsonMapper flickrJsonMapper;

    @Before
    public void setUp() {
        JSON_RESPONSE_FLICKR_PHOTO = new TestUtil().loadResourceFile("flickr_photo.json");
        JSON_RESPONSE_FLICKR_PHOTO_LIST = new TestUtil().loadResourceFile("flickr_photo_list.json");
        flickrJsonMapper = new FlickrJsonMapper();
    }

    @Test
    public void testConvertFlickrPhoto() {
        FlickrPhotoEntity flickrPhotoEntity = flickrJsonMapper.parseFlickrPhoto
                (JSON_RESPONSE_FLICKR_PHOTO);

        assertNotNull(flickrPhotoEntity);
        assertEquals(flickrPhotoEntity.getId(), "35923289165");
        assertEquals(flickrPhotoEntity.getTitle(), "Moz");
    }

    @Test
    public void testConvertFlickrPhotoList() {
        List<FlickrPhotoEntity> flickrPhotoEntityList = flickrJsonMapper.parseFlickrResponse
                (JSON_RESPONSE_FLICKR_PHOTO_LIST);

        assertNotNull(flickrPhotoEntityList);
        assertEquals(flickrPhotoEntityList.size(), 3);
        assertEquals(flickrPhotoEntityList.get(0).getId(), "35923289165");
        assertEquals(flickrPhotoEntityList.get(1).getId(), "35791595021");
    }

}
