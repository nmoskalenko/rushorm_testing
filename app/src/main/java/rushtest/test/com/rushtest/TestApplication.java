package rushtest.test.com.rushtest;

import android.app.Application;

import co.uk.rushorm.android.AndroidInitializeConfig;
import co.uk.rushorm.core.RushCore;

/**
 * Created by Nickolay Moskalenko on 7/29/15.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidInitializeConfig config = new AndroidInitializeConfig(getApplicationContext());
        RushCore.initialize(config);
    }
}
