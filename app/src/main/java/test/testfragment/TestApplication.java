package test.testfragment;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by king on 2017/11/9.
 */

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
