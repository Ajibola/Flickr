package sample.app.domain.interactor;

/**
 * Created by hp on 7/14/2017.
 */

public interface DefaultListener<T> {

    void onFailure(Throwable exception);

    void onSuccess(T t);
}
