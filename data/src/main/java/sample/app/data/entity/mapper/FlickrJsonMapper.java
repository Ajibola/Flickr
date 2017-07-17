package sample.app.data.entity.mapper;

import sample.app.data.App;
import sample.app.data.R;
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

    /**
     * class method to convert a response string containing a flickr photo to the FlickrPhotoEntity data object
     *
     * {
     * "id": "35923289165",
     * "owner": "40081731@N05",
     * "secret": "d4de32f357",
     * "server": "4214",
     * "farm": 5,
     * "title": "Moz",
     * "ispublic": 1,
     * "isfriend": 0,
     * "isfamily": 0
     * }
     *
     * @param userJsonResponse json string to be mapped
     * @return a data object of type FlickrPhotoEntity
     */
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
                Log.d(TAG, App.getContext().getString(R.string.parse_flickr_photo_error));
            }
        }

        return flickrPhotoEntity;
    }

    /**
     * converts the flickr api response string json object to a list containing FlickrPhotoEntity data objects
     *
     * {
     * "photos": {
     * "page": 1,
     * "pages": 1806,
     * "perpage": 100,
     * "total": "180534",
     * "photo": []
     * }
     * }
     * *
     *
     * @param flickJsonResponse a json string containing a photos object
     * @return a list of FlickrPhotoEntity data objects
     */
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
            Log.d(TAG, App.getContext().getString(R.string.parse_flickr_photo_list_error));
        }

        return flickrPhotoEntities;
    }
}
