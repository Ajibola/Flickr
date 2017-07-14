package sample.app.flickr.model;

import java.io.Serializable;

/**
 * Data object for holding the photos details.
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

    public String getUrl() {
        return url;
    }
}
