package com.example.client;

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

import com.example.service.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
     private Button mButton;

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
        mTextView=(TextView) findViewById(R.id.tt3);
        mButton=(Button) findViewById(R.id.BT33);
        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
                        //MyService.class自定义继承的服务类
                        Intent intent=new Intent();
                        intent.setAction("com.jay.example.service.123456");
                        intent.setPackage("com.example.service");
                        startService(intent);
                        Log.v("TAG", "123456");
                        bindService(intent, my, BIND_AUTO_CREATE);

        			}

        		});




    }

}
