package top.itmp.uidemo.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by hz on 2016/4/5.
 */
public class TopApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
