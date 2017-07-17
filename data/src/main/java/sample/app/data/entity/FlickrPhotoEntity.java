package sample.app.data.entity;

/**
 * Object represenation for json response from flickr image search API
 */
public class FlickrPhotoEntity {

    private String id;
    private String secret;
    private String server;
    private int farm;
    private String title;

    /**
     * @return the id for the data object
     */
    public String getId() {
        return id;
    }

    /**
     * sets the id for the data object
     *
     * @param id sets the id to this vale
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * sets the secret variable
     *
     * @param secret sets the secret variable to this value
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return the server variable
     */
    public String getServer() {
        return server;
    }

    /**
     * sets the server variable
     *
     * @param server sets the server variable to this value
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the farm variable
     */
    public int getFarm() {
        return farm;
    }

    /**
     * sets the farm variable
     *
     * @param farm sets the farm variable to this value
     */
    public void setFarm(int farm) {
        this.farm = farm;
    }

    /**
     * @return the title variable
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title variable
     *
     * @param title sets the title variable to this value
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
