package com.example.jiangxiaolin.firsttest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jiangxiaolin.myapplication.IMyAidlInterface;


/**
 * Created by jiangxiaolin on 2019/7/9.
 */

public class Myservice extends Service {
    IMyAidlInterface.Stub mStub=new IMyAidlInterface.Stub() {
        @Override
        public int basicTypes(int anInt, int bnint) throws RemoteException {
            return anInt+bnint;
        }
    };

//    public class addfan extends IMyAidlInterface.Stub{
//
//
//        @Override
//        public int basicTypes(int anInt, int bnint) throws RemoteException {
//            return anInt+bnint;
//        }
//    }

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

        return mStub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public Myservice() {
        super();
    }
}
