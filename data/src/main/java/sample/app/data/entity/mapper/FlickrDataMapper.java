package sample.app.data.entity.mapper;

import sample.app.data.App;
import sample.app.data.R;
import sample.app.data.entity.FlickrPhotoEntity;
import sample.app.domain.model.FlickrPhoto;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts photo entity to domain photo data object
 */
public class FlickrDataMapper {

    /**
     * converts the data object of type FlickrPhotoEntity to a new data object of type FlickrPhoto
     *
     * @param flickrPhotoEntity source object to be converted
     * @return returns a FlickrPhoto object
     */
    private FlickrPhoto convert(FlickrPhotoEntity flickrPhotoEntity) {
        FlickrPhoto flickrPhoto = null;

        if (flickrPhotoEntity != null) {
            flickrPhoto = new FlickrPhoto("", "");
            String url = String.format(App.getContext().getString(R.string.flickr_url_string),
                    flickrPhotoEntity.getFarm(),
                    flickrPhotoEntity.getServer(), flickrPhotoEntity.getId(),
                    flickrPhotoEntity.getSecret());
            flickrPhoto.setTitle(flickrPhotoEntity.getTitle());
            flickrPhoto.setUrl(url);
        }

        return flickrPhoto;
    }

    /**
     * converts a list filled with data objects of type FlickrPhotoEntity into a new list with data objects
     * of type FlickrPhoto
     *
     * @param flickrPhotoEntityList list of objects to be converted
     * @return a list of FlickrPhoto objects
     */
    public List<FlickrPhoto> convertList(List<FlickrPhotoEntity> flickrPhotoEntityList) {
        List<FlickrPhoto> flickrPhotoList = new ArrayList<>();

        for (FlickrPhotoEntity flickrPhotoEntity : flickrPhotoEntityList) {
            FlickrPhoto flickrPhoto = convert(flickrPhotoEntity);
            flickrPhotoList.add(flickrPhoto);
        }

        return flickrPhotoList;
    }
}
