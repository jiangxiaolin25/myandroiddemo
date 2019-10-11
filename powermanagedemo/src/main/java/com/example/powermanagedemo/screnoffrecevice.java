package com.example.powermanagedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

import static android.content.Context.POWER_SERVICE;

/**
 * 作者：jiangxiaolin on 2019/10/11
 * 邮箱：jiangxiaolin@xgd.com
 * ToDo：
 */
public class screnoffrecevice extends BroadcastReceiver {
    private PowerManager.WakeLock wakeLock;
     private String action="android.intent.action.SCREEN_OFF";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(action.equals(intent.getAction())){
            Log.v("TAG","广播onReceive");
            PowerManager pm = (PowerManager) context.getSystemService(POWER_SERVICE);
//            wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
//                    | PowerManager.ON_AFTER_RELEASE, "DPA");

            wakeLock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
            //这里就是保持机器是亮屏的状态，后面的时间是多少秒后自动释放锁，也就可以熄屏了，不过还要等待系统设置的熄屏时间后才会熄屏
            wakeLock.acquire(30*1000);
//            wakeLock.release();

        }


    }
}
