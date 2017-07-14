package sample.app.flickr.model;

import java.io.Serializable;

/**
 * Created by hp on 7/14/2017.
 */

public class Photo implements Serializable {

    private String title;
    private String url;

    public Photo(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
