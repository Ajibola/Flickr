package sample.app.flickr.search;

/**
 * Created by hp on 7/14/2017.
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);
}
