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

    private String jsonResponseFlickrPhoto;
    private String jsonResponseFlickrPhotoList;
    private FlickrJsonMapper flickrJsonMapper;

    @Before
    public void setUp() {
        jsonResponseFlickrPhoto = new TestUtil().loadResourceFile("flickr_photo.json");
        jsonResponseFlickrPhotoList = new TestUtil().loadResourceFile("flickr_photo_list.json");
        flickrJsonMapper = new FlickrJsonMapper();
    }

    @Test
    public void testConvertFlickrPhoto() {
        FlickrPhotoEntity flickrPhotoEntity = flickrJsonMapper.parseFlickrPhoto(jsonResponseFlickrPhoto);

        assertNotNull(flickrPhotoEntity);
        assertEquals(flickrPhotoEntity.getId(), "35923289165");
        assertEquals(flickrPhotoEntity.getTitle(), "Moz");
    }

    @Test
    public void testConvertFlickrPhotoList() {
        List<FlickrPhotoEntity> flickrPhotoEntityList = flickrJsonMapper.parseFlickrResponse(
                jsonResponseFlickrPhotoList);

        assertNotNull(flickrPhotoEntityList);
        assertEquals(flickrPhotoEntityList.size(), 3);
        assertEquals(flickrPhotoEntityList.get(0).getId(), "35923289165");
        assertEquals(flickrPhotoEntityList.get(1).getId(), "35791595021");
    }

}
