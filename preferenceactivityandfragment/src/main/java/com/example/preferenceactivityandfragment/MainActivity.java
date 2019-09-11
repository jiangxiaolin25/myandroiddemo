package com.example.preferenceactivityandfragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.preference.PreferenceActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button) findViewById(R.id.bt1);
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        mypreferencefragment name=new mypreferencefragment();
//         fragmentTransaction.replace(R.id.FL1, name).commit();


        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
                        Intent intent=new Intent(MainActivity.this, mpreference.class);
                        intent.setAction("android.intent.action.MAIN");
                        startActivity(intent);



        			}

        		});

    }

}
