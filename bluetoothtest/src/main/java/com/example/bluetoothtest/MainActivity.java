package com.example.bluetoothtest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    ArrayList mArrayList = new ArrayList();
    int sp;
    BluetoothAdapter blueadapter;
    static PowerManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        blueadapter = BluetoothAdapter.getDefaultAdapter();
        mTextView = (TextView) findViewById(R.id.TV1);
        try {
            sp = getSP();
            sp = ++sp;
            result("开始 第" + sp + "次测试\r\n");
            putSP(sp);
            Thread.sleep(1000);


            Log.v("TAG","开始准备休眠");

            PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, this.getClass().getName());
            wakeLock.setReferenceCounted(false);
            wakeLock.acquire();

            wakeLock.release();
            Thread.sleep(5*1000);
            Log.v("TAG","休眠");

            MainActivity.result("终端休眠成功");
            wakeLock.acquire();
            Log.v("TAG","唤醒");




//            //进入蓝牙界面
            startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));//直接进入手机中的蓝牙设置界面
            //注册广播
            IntentFilter mFilter = new IntentFilter();
            // 添加接收网络连接状态改变的Action
            mFilter.addAction(BluetoothDevice.ACTION_FOUND);
            mFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
            registerReceiver(mReceiver, mFilter);
            Log.v("TAG", "广播启动完成");

            //启动线程1
            mythread name = new mythread(blueadapter);
//            mythread2 name1=new mythread2(mArrayList,pm,blueadapter);

            name.start();
            name.join();
            //休眠唤醒然后搜索蓝牙设备
            mythread2 name1=new mythread2(mArrayList,pm,blueadapter);
            name1.sleep(10*1000);
            name1.start();
//                    blueadapter.disable();
//                    this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//                    Thread.sleep(2*1000);
//                    this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//                    Thread.sleep(2*1000);
//                    this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


//            Class cc=PowerManager.class;
//            Method goToSleep = cc.getMethod("goToSleep", long.class);
//            Method wakeUp = cc.getMethod("wakeUp", long.class);
////            goToSleep(SystemClock.uptimeMillis());
//            goToSleep.invoke(cc.newInstance(),SystemClock.uptimeMillis());
//            Thread.sleep(2000);
//            wakeUp.invoke(cc.newInstance(),SystemClock.uptimeMillis());









//            if (mArrayList.size() > 3) {
//                result("蓝牙测试成功");
//            } else {
//                result("蓝牙测试失败");
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(mReceiver);
    }

    public void name() {

        if (blueadapter == null) {
            Toast.makeText(MainActivity.this, "设备不支持蓝牙", Toast.LENGTH_SHORT).show();
//            return "设备不支持蓝牙";
        }
        if (blueadapter.isEnabled()) {
            if (blueadapter.isDiscovering()) {
                blueadapter.cancelDiscovery();
            }
            blueadapter.startDiscovery();

        }
        blueadapter.enable();
        blueadapter.startDiscovery();
//          return "测试";
    }


    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent)

        {
            Log.v("TAG", "监听到广播了");

            String action = intent.getAction();
            if (action.equals(BluetoothDevice.ACTION_FOUND)) ;
            {
                Log.v("TAG", "已经搜索到设备了");
                BluetoothDevice device = intent
                        .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mArrayList.add(device);

            }
            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                Log.v("TAG", "设置搜索完成");
                Log.v("TAG", "" + mArrayList.size());
                try {
                    if (mArrayList.size() != 0) {
                        result("蓝牙测试成功" + sp);

//                        blueadapter.disable();
//                        Intent intent1=new Intent(MainActivity.this, MainActivity.class);
//                        intent.setAction("android.intent.action.MAIN");
//                        startActivity(intent);
                    } else {
                        result("蓝牙测试失败" + sp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    };

    public static void result(String txt) throws IOException {
        Log.v("TAG", "result");
        /***
         * 需要添加权限才能创建一个文件
         */
        File file = new File("/mnt/sdcard/123.txt");
        if (!file.exists()) {
//            file.delete();
            Log.v("TAG", "createNewFile");

            file.createNewFile();
        }

        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
        output.append(txt + "\n");
        output.close();


    }

    private int getSP() {
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        int u = preferences.getInt("key", 0);
        return u;
//		String p = preferences.getString("psw","");


    }

    private void putSP(int i) {
//		int i=1;
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        // 存数据
        editor.putInt("key", i);
//		editor.putString("psw", p);
//		editor.putBoolean("remember", true);
//提交
        editor.commit();

    }


}
