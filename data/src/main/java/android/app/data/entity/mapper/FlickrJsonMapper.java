package android.app.data.entity.mapper;

import android.app.data.entity.FlickrPhotoEntity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public class FlickrJsonMapper {

    private static final String TAG = FlickrJsonMapper.class.getSimpleName();

    public FlickrJsonMapper() {
    }

    public FlickrPhotoEntity parseFlickrPhoto(String userJsonResponse) {
        FlickrPhotoEntity flickrPhotoEntity = new FlickrPhotoEntity();

        if (userJsonResponse != null) {
            try {
                JSONObject jsonObject = new JSONObject(userJsonResponse);

                if (jsonObject != null) {
                    flickrPhotoEntity.setId(jsonObject.optString("id"));
                    flickrPhotoEntity.setOwner(jsonObject.optString("owner"));
                    flickrPhotoEntity.setSecret(jsonObject.optString("secret"));
                    flickrPhotoEntity.setServer(jsonObject.optString("server"));
                    flickrPhotoEntity.setFarm(jsonObject.optInt("farm"));
                    flickrPhotoEntity.setTitle(jsonObject.optString("title"));
                    flickrPhotoEntity.setPublic(jsonObject.optBoolean("ispublic"));
                    flickrPhotoEntity.setFriend(jsonObject.optBoolean("isfriend"));
                    flickrPhotoEntity.setFamily(jsonObject.optBoolean("isfamily"));
                }
            } catch (JSONException ex) {
                Log.d(TAG, "Error parsing Flickr response");
            }
        }

        return flickrPhotoEntity;
    }

    public List<FlickrPhotoEntity> parseFlickrResponse(String flickJsonResponse) {
        List<FlickrPhotoEntity> flickrPhotoEntities = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(flickJsonResponse);

            if (jsonObject != null) {
                JSONArray resultArray = jsonObject.optJSONArray("photo");
                if (resultArray != null) {
                    for (int i = 0; i < resultArray.length(); i++) {
                        JSONObject photoObject = resultArray.optJSONObject(i);
                        FlickrPhotoEntity flickrPhotoEntity = parseFlickrPhoto(photoObject.toString());
                        flickrPhotoEntities.add(flickrPhotoEntity);
                    }
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "fail to parse flickr response ");
        }

        return flickrPhotoEntities;
    }
}
