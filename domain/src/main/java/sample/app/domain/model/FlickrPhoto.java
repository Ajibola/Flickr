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

    /**
     * @return returns the title variable
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title variable
     *
     * @param title new value for title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the url variable
     */
    public String getUrl() {
        return url;
    }

    /**
     * sets the url variable to this value
     *
     * @param url new value for url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
