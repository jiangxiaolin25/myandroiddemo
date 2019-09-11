package com.example.bluetoothtest;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jiangxiaolin on 2019/8/19.
 */

public class mythread extends Thread {
    BluetoothAdapter blueadapter;

    public mythread(BluetoothAdapter blueadapter) {
        this.blueadapter = blueadapter;
    }

    @Override
    public void run() {
        super.run();
        {
//            blueadapter = BluetoothAdapter.getDefaultAdapter();
            if (blueadapter == null) {
                Log.v("TAG", "设备不支持蓝牙");

//                Toast.makeText(MainActivity.this, "设备不支持蓝牙", Toast.LENGTH_SHORT).show();
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
    }
}

class mythread2 extends Thread {

    BluetoothAdapter blueadapter;
    ArrayList mArrayList;
    PowerManager pm;


    public mythread2(ArrayList mArrayList, PowerManager pm, BluetoothAdapter blueadapter) {
        this.mArrayList = mArrayList;
        this.pm = pm;
        this.blueadapter = blueadapter;
    }

    @Override
    public void run() {
        super.run();
        if (mArrayList.size() > 5) {
            blueadapter.disable();
            try {
                MainActivity.result("蓝牙关闭成功");

//            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, this.getClass().getName());
                wakeLock.release();
                MainActivity.result("终端休眠成功");
                wakeLock.acquire();
                MainActivity.result("终端唤醒成功成功");
                blueadapter.enable();
                blueadapter.startDiscovery();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


