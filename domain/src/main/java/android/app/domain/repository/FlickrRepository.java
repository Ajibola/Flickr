package android.app.domain.repository;

import android.app.domain.model.FlickrPhoto;

import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public interface FlickrRepository {

    List<FlickrPhoto> getSearchPhotos(String text, String page);
}
