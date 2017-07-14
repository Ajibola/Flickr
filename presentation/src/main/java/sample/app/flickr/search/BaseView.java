package sample.app.flickr.search;

/**
 * Method definitions to be included in all views that inherit BaseView
 */
public interface BaseView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);
}
