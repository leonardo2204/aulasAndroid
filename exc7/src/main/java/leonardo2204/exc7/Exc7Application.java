package leonardo2204.exc7;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by leonardo on 2/16/17.
 */

public class Exc7Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
