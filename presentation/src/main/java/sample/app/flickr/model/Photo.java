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

    /**
     * @return the title variable
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the url variable
     */
    public String getUrl() {
        return url;
    }
}
