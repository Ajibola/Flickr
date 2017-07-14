package android.app.domain.repository;

import android.app.domain.interactor.DefaultListener;
import android.app.domain.model.FlickrPhoto;

import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public interface FlickrRepository {

    void getSearchPhotos(String text, String page, DefaultListener<List<FlickrPhoto>> defaultListener);
}
