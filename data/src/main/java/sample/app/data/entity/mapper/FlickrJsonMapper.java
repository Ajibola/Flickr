package sample.app.data.entity.mapper;

import sample.app.data.entity.FlickrPhotoEntity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts json string to object or list of objects
 */
public class FlickrJsonMapper {

    private static final String TAG = FlickrJsonMapper.class.getSimpleName();

    public FlickrJsonMapper() {
    }

    FlickrPhotoEntity parseFlickrPhoto(String userJsonResponse) {
        FlickrPhotoEntity flickrPhotoEntity = new FlickrPhotoEntity();

        if (userJsonResponse != null) {
            try {
                JSONObject jsonObject = new JSONObject(userJsonResponse);

                flickrPhotoEntity.setId(jsonObject.optString("id"));
                flickrPhotoEntity.setSecret(jsonObject.optString("secret"));
                flickrPhotoEntity.setServer(jsonObject.optString("server"));
                flickrPhotoEntity.setFarm(jsonObject.optInt("farm"));
                flickrPhotoEntity.setTitle(jsonObject.optString("title"));
            } catch (JSONException ex) {
                Log.d(TAG, "Error parsing Flickr response");
            }
        }

        return flickrPhotoEntity;
    }

    public List<FlickrPhotoEntity> parseFlickrResponse(String flickJsonResponse) {
        List<FlickrPhotoEntity> flickrPhotoEntities = new ArrayList<>();
        try {
            if (flickJsonResponse != null) {
                JSONObject jsonObject = new JSONObject(flickJsonResponse);
                JSONObject photosJSONObject = jsonObject.optJSONObject("photos");

                if (photosJSONObject != null) {
                    JSONArray resultArray = photosJSONObject.optJSONArray("photo");
                    if (resultArray != null) {
                        for (int i = 0; i < resultArray.length(); i++) {
                            JSONObject photoObject = resultArray.optJSONObject(i);
                            FlickrPhotoEntity flickrPhotoEntity = parseFlickrPhoto(photoObject.toString());
                            flickrPhotoEntities.add(flickrPhotoEntity);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "fail to parse flickr response ");
        }

        return flickrPhotoEntities;
    }
}
