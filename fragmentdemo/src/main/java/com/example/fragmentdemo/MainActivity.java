package com.example.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Log.v("TAG","onCreate");

        Myfragment1 name=new Myfragment1();
        getFragmentManager().beginTransaction().replace(R.id.LinearLayout1,name).commit();
    }
}
