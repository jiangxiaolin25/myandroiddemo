package com.example.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    //需要创建在oncreate签名
    private ServiceConnection my = new ServiceConnection() {
        //服务断开的时候调用的
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v("TAG", "MyService onServiceDisconnected服务解绑");
        }

        //服务绑定的时候调用的    当服务的onBind()返回一个对象的时候才被调用的
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.v("TAG", "MyService onServiceConnected服务绑定");
            IMyAidlInterface myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                int i = myAidlInterface.basicTypes(55, 99);
                mTextView.setText("" + i);
                Log.v("TAG", "" + i);

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView) findViewById(R.id.tt);
        //MyService.class自定义继承的服务类
//        Intent intent=new Intent(this,Fuwu.class);
//        intent.setAction("com.jay.example.service.123456");
//        intent.setPackage("com.example.jiangxiaolin.firsttest");
//        startService(intent);
//        Log.v("TAG", "开始bind");
//        bindService(intent, my, BIND_AUTO_CREATE);
    }
}
