package com.example.simcardstatue;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;

import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by jiangxiaolin on 2019/8/12.
 */

public class myservicer extends Service {
//    public myservicer(String name) {
//        super(name);
//    }
    public myservicer( ) {
        super();
         Log.v("TAG","myservicer");

    }



    private final static int SIM_VALID = 0;
    private final static int SIM_INVALID = 1;
    private int simState = SIM_INVALID;
    String SIMstatus="android.intent.action.SIM_STATE_CHANGED";
//    public static String getImsi(Context context) {
////        TelephonyManager tm = (TelephonyManager) context
////                .getSystemService(Context.TELEPHONY_SERVICE);
////        String deviceid = tm.getDeviceId();// 获取智能设备唯一编号
////        String te1 = tm.getLine1Number();// 获取本机号码
////        String simei = tm.getSimSerialNumber();// 获得SIM卡的序号
////        String imsi = tm.getSubscriberId();// 得到用户Id
////        if (imsi != null && !imsi.equals("")) {
////            Log.v("TAG", "获取手机信息====Deviceid" + deviceid + "teleNum" + te1
////                    + "SimNUM" + simei + "UserId" + imsi);
////            return imsi;
////        }
////        return "未知";
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         Log.v("TAG","广播onDestroy");

    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent) {
             Log.v("TAG","启动广播接收者");

            String action = intent.getAction();
            if (action.equals(SIMstatus)) ;
            {
                Log.v("TAG","intent相同监听到网络发生改变");
                try {
                    Log.v("TAG","进入休眠状态...");
                    Thread.sleep(30*1000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v("TAG","休眠唤醒");
                TelephonyManager tm = (TelephonyManager) context
                        .getSystemService(Service.TELEPHONY_SERVICE);

                String type = "unknown";
                ConnectivityManager cm = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = cm.getActiveNetworkInfo();
                if (info == null) {
                    type = "unknown";
                    Log.v("TAG",type);
                } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    type = "wifi";
                    Log.v("TAG",type);
                } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    int subType = info.getSubtype();
                    if (subType == TelephonyManager.NETWORK_TYPE_CDMA
                            || subType == TelephonyManager.NETWORK_TYPE_GPRS
                            || subType == TelephonyManager.NETWORK_TYPE_EDGE) {
                        type = "2g";
                        Log.v("TAG",type);
                    } else if (subType == TelephonyManager.NETWORK_TYPE_UMTS
                            || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                            || subType == TelephonyManager.NETWORK_TYPE_EVDO_A
                            || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                            || subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
                        type = "3g";
                        Log.v("TAG",type);
                    } else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
                        type = "4g";
                         Log.v("TAG",type);

                    }
                }

                int state = tm.getSimState();
                switch (state) {
                    case TelephonyManager.SIM_STATE_READY:
//                        Toast.makeText(context,
//                                "state:" + state + " Imsi " + getImsi(context),
//                                Toast.LENGTH_LONG).show();
//                        simState = SIM_VALID;
                        break;
                    case TelephonyManager.SIM_STATE_UNKNOWN:
                        Log.v("TAG", "" + TelephonyManager.SIM_STATE_UNKNOWN);

                    case TelephonyManager.SIM_STATE_ABSENT:
                        Log.v("TAG", "" + TelephonyManager.SIM_STATE_ABSENT);

                    case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                        Log.v("TAG", "" + TelephonyManager.SIM_STATE_PIN_REQUIRED);

                    case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                        Log.v("TAG", "" + TelephonyManager.SIM_STATE_PUK_REQUIRED);

                    case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                        Log.v("TAG", "" + TelephonyManager.SIM_STATE_NETWORK_LOCKED);

                    default:
//                        simState = SIM_INVALID;
                        break;

                }
            }
        }
    };



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//
//
//    }



    @Override
    public void onCreate() {
        super.onCreate();
         Log.v("TAG","服务onCreate");
        //注册广播
        Log.v("TAG","开始了服务");

        IntentFilter mFilter = new IntentFilter();
        // 添加接收网络连接状态改变的Action
        mFilter.addAction(SIMstatus);
        registerReceiver(mReceiver, mFilter);



    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);

    }
}
