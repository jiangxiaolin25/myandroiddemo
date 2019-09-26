package com.example.preferenceactivityandfragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static android.content.Context.MODE_WORLD_READABLE;

/**
 * Created by jiangxiaolin on 2019/7/24.
 */

public class mypreferencefragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesMode(MODE_WORLD_READABLE);
        addPreferencesFromResource(R.xml.fragment1);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findPreference("two").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "two", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        findPreference("one").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "two", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
