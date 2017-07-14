package android.app.domain.interactor;

import android.app.domain.model.FlickrImage;

import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public interface SearchPhotoInteractor {

    public List<FlickrImage> searchImage(String text);
}
