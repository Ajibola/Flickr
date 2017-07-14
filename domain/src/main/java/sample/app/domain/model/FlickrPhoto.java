package sample.app.domain.model;

/**
 * Holds the photo object in the domain
 */
public class FlickrPhoto {

    private String title;
    private String url;

    public FlickrPhoto(String title, String url) {
        this.title = title;
        this.url = url;
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
