package top.itmp.uidemo.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.concurrent.atomic.AtomicInteger;

import top.itmp.uidemo.R;
import top.itmp.uidemo.base.BaseActivity;
import top.itmp.uidemo.ui.fragment.MainPreferenceFragment;

/**
 * Created by hz on 2016/4/7.
 */
public class SettingsActivity extends BaseActivity {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(layoutParams);

        Toolbar toolbar = (Toolbar) getLayoutInflater().inflate(R.layout.app_toolbar, null);

        linearLayout.addView(toolbar);
        linearLayout.addView(frameLayout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            frameLayout.setId(View.generateViewId());
        } else {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF)
                    newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    frameLayout.setId(result);
                    break;
                }
            }
        }
        setContentView(linearLayout);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        supportInvalidateOptionsMenu();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getUpArrow(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        // parse the UpArrow Color
        upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        /** 1. setup UpArrow **/
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        /** 2. setup UpArrow **/
        //toolbar.setNavigationIcon(upArrow);

        getFragmentManager().beginTransaction().replace(frameLayout.getId(), MainPreferenceFragment.instance()).commit();
    }

    private Drawable getUpArrow(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getResources().getDrawable(id, getTheme());
        } else {
            return getDrawable(id);
        }
    }
}
