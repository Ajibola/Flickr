package android.app.domain.model;

/**
 * Created by hp on 7/13/2017.
 */

public class FlickrImage {
    
    private String title;
    private String url;

    public FlickrImage(String title, String url) {
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
