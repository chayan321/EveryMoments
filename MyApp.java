package chayan.everymoments;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by CHAYAN_PC on 30-01-2018.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1000);
    }
}
