package com.example.simcardstatue;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
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
        mButton=(Button) findViewById(R.id.BT1);
        final Intent intent=new Intent(this,myservicer.class);
        intent.setAction("com.jay.example.service.TEST_SERVICE1");


        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
                        //MyService.class自定义继承的服务类


                        startService(intent);


        			}

        		});
    }
}
