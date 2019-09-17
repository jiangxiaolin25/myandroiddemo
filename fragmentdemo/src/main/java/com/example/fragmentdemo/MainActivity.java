package com.example.fragmentdemo;

import android.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Log.v("TAG","onCreate");


        Myfragment1 name=new Myfragment1();
        getFragmentManager().beginTransaction().replace(R.id.fagment1,name).commit();
    }
}
