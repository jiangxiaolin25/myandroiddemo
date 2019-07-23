package com.example.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jiangxiaolin.myapplication.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    private IMyAidlInterface mIMyAidlInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.bT2);
        mTextView = (TextView) findViewById(R.id.tx2);


    }
}
