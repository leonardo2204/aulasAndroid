package leonardo2204.exc6;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by leonardo on 2/15/17.
 */

public class Exc6Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
