package sample.app.domain.interactor;

/**
 * Defines call back methods that will be implemented by subclasses
 * @param <T>
 */
public interface DefaultListener<T> {

    void onFailure(Throwable exception);

    void onSuccess(T t);
}
