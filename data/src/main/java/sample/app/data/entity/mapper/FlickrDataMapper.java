package sample.app.data.entity.mapper;

import sample.app.data.entity.FlickrPhotoEntity;
import sample.app.domain.model.FlickrPhoto;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts photo entity to domain photo data object
 */
public class FlickrDataMapper {

    public FlickrDataMapper() {
    }

    private FlickrPhoto convert(FlickrPhotoEntity flickrPhotoEntity) {
        FlickrPhoto flickrPhoto = null;

        if (flickrPhotoEntity != null) {
            flickrPhoto = new FlickrPhoto("", "");
            String url = "http://farm" + Integer.toString(flickrPhotoEntity.getFarm()) + ".static.flickr"
                    + ".com/" + flickrPhotoEntity.getServer() + "/" + flickrPhotoEntity.getId() + "_"
                    + flickrPhotoEntity.getSecret()
                    + ".jpg";
            flickrPhoto.setTitle(flickrPhotoEntity.getTitle());
            flickrPhoto.setUrl(url);
        }

        return flickrPhoto;
    }

    public List<FlickrPhoto> convertList(List<FlickrPhotoEntity> flickrPhotoEntityList) {
        List<FlickrPhoto> flickrPhotoList = new ArrayList<>();

        for (FlickrPhotoEntity flickrPhotoEntity : flickrPhotoEntityList) {
            FlickrPhoto flickrPhoto = convert(flickrPhotoEntity);
            flickrPhotoList.add(flickrPhoto);
        }

        return flickrPhotoList;
    }
}
