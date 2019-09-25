package com.example.handlepost;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button mTextView;
    private   Handler name=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mTextView = (Button) findViewById(R.id.handle);
        mTextView.setOnClickListener(new Button.OnClickListener() {

         			@Override
         			public void onClick(View v) {
         				// TODO Auto-generated method stub
                        try {
                            name.post(mRunnablename);
                            Thread.sleep(2000);
                            name.post(mRunnablename1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
         			}

         		});
    }
    Runnable mRunnablename=new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                 Log.v("TAG","mRunnablename**************"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };
    Runnable mRunnablename1=new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                 Log.v("TAG","mRunnablename1**************"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };
}
