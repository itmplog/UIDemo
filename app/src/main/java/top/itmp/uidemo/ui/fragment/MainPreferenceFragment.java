package top.itmp.uidemo.ui.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import top.itmp.uidemo.R;

/**
 * Created by dp on 2017/12/7.
 */

public class MainPreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Preference preference = findPreference("preference");
        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                new AlertDialog.Builder(getActivity())
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle(preference.getTitle())
                        .setMessage(preference.getSummary())
                        .setNegativeButton(android.R.string.cancel, null)
                        .setPositiveButton(android.R.string.ok, null)
                        .create()
                        .show();
                return true;
            }
        });
    }

    public static MainPreferenceFragment instance() {
        return new MainPreferenceFragment();
    }
}
