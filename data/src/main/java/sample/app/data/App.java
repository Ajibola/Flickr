package sample.app.data;

import android.app.Application;
import android.content.Context;

/**
 * Application class that provides context object to the data module
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = base;
    }

    /**
     * returns a context object
     *
     * @return the application context
     */
    public static Context getContext() {
        return mContext;
    }
}
