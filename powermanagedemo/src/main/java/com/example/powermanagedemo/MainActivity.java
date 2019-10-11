package com.example.powermanagedemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean iswakeLock = true;// 是否常亮
    private PowerManager.WakeLock wakeLock;
     private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button) findViewById(R.id.woke);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        screnoffrecevice receiver = new screnoffrecevice();
        registerReceiver(receiver, intentFilter);

        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub


//                        if (iswakeLock) {

//                        }
//                        android.os.Process.killProcess(android.os.Process.myPid());


        			}

        		});
    }

    @Override
    protected void onPause() {
        super.onPause();
         Log.v("TAG","onPause");
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
//        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
//                | PowerManager.ON_AFTER_RELEASE, "DPA");
//        wakeLock.acquire();
////        wakeLock.release();


//        if (wakeLock != null) {
//            wakeLock.release();
//        }
//        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    protected void onResume() {
         Log.v("TAG","onResume");



        super.onResume();

    }
}
