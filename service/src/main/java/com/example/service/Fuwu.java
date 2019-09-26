package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by jiangxiaolin on 2019/7/10.
 */

public class Fuwu  extends Service {

    IMyAidlInterface.Stub imystub=new IMyAidlInterface.Stub() {
        @Override
        public int basicTypes(int anInt, int bInt) throws RemoteException {
            return anInt+bInt;
        }
    };
    public Fuwu() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
         Log.v("TAG","onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         Log.v("TAG","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
         Log.v("TAG","onBind");

        return imystub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
         Log.v("TAG","onUnbind");

        return super.onUnbind(intent);
    }
}


