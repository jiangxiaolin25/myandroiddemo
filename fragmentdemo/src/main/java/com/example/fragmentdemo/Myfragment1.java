package com.example.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by jiangxiaolin on 2019/7/23.
 */

public class Myfragment1 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Log.v("TAG","onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

//        View inflate = inflater.inflate(R.layout.fragment1, container, false);
        View view = inflater.inflate(R.layout.fragment1, container,false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         Log.v("TAG","onViewCreated");



    }

    @Override
    public void onStart() {
        super.onStart();
         Log.v("TAG","onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
         Log.v("TAG","onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
         Log.v("TAG","onPause");

    }
}
