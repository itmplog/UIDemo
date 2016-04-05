package top.itmp.uidemo.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import top.itmp.uidemo.R;

/**
 * Created by hz on 2016/4/5.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    public void setFragment(int view_id, Fragment fragment){
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(view_id, fragment);
        mFragmentTransaction.commit();
    }
}