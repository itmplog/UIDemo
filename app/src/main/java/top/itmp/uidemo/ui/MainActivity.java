package top.itmp.uidemo.ui;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import top.itmp.uidemo.R;
import top.itmp.uidemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                //super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //super.onDrawerClosed(drawerView);
                supportInvalidateOptionsMenu();
            }
        };
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mDrawerLayout.removeDrawerListener(mActionBarDrawerToggle);
    }
}
