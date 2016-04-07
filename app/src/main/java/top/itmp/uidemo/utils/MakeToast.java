package top.itmp.uidemo.utils;


import android.widget.Toast;

import top.itmp.uidemo.base.TopApplication;

/**
 * Created by hz on 2016/4/6.
 */
public class MakeToast {

    public static void Short(CharSequence charSequence) {
        Toast.makeText(TopApplication.mContext, charSequence, Toast.LENGTH_SHORT).show();
    }

    public static void Long(CharSequence charSequence) {
        Toast.makeText(TopApplication.mContext, charSequence, Toast.LENGTH_LONG).show();
    }
}
