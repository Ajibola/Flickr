package sample.app.domain.interactor;

/**
 * Defines call back methods that will be implemented by subclasses
 *
 * @param <T>
 */
public interface DefaultListener<T> {

    /**
     * passes a throwable exception object
     *
     * @param exception the exception that is passed to the implementation
     */
    void onFailure(Throwable exception);

    /**
     * passes an object of the generics type T on success
     *
     * @param t the generic object passed
     */
    void onSuccess(T t);
}
