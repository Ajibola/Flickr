package sample.app.flickr.model;

import sample.app.domain.model.FlickrPhoto;

import java.util.ArrayList;
import java.util.List;

/**
 * Maps the domain layer flickr photo object to the presentation layers photo data object
 */
public class PhotoDataMapper {

    public PhotoDataMapper() {
    }

    private Photo convert(FlickrPhoto flickrPhoto) {
        Photo photo = null;

        if (flickrPhoto != null) {
            photo = new Photo(flickrPhoto.getUrl(), flickrPhoto.getTitle());
        }

        return photo;
    }

    public List<Photo> convertList(List<FlickrPhoto> flickrPhotoList) {
        List<Photo> photoList = new ArrayList<>();

        for (FlickrPhoto flickrPhoto : flickrPhotoList) {
            Photo photo = convert(flickrPhoto);
            photoList.add(photo);
        }

        return photoList;
    }
}
