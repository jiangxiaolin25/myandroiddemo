package com.example.aidlclien2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jiangxiaolin.myapplication.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=new Intent("co.example.leo.myService");
//        			intent.setAction("co.example.leo.myService");
        intent.setPackage("com.example.jiangxiaolin.firsttest");
         Log.v("TAG","MainActivity");

        bindService(intent, new ServiceConnection() {
        			//服务断开的时候调用的
        			@Override
        			public void onServiceDisconnected(ComponentName name) {
        				Log.v("TAG", "MyService onServiceDisconnected服务解绑");
        			}
        			//服务绑定的时候调用的    当服务的onBind()返回一个对象的时候才被调用的
        			@Override
        			public void onServiceConnected(ComponentName name, IBinder service) {
        				Log.v("TAG", "MyService onServiceConnected服务绑定");
                        IMyAidlInterface myAidlInterface=IMyAidlInterface.Stub.asInterface(service);
                        try {
                            int i = myAidlInterface.basicTypes(45, 45);
                             Log.v("TAG",""+i);

                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
        		}, BIND_AUTO_CREATE);

    }
}
