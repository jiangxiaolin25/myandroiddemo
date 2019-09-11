package com.example.jiangxiaolin.firsttest;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jiangxiaolin.myapplication.IMyAidlInterface;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     private TextView mTextView1;
     private Button  mButton;
     private Button  mButton1;
     private ProgressBar mProgressBar;


    public class common123 extends AsyncTask< String, Integer, String> {
//    private TextView mTextView1;
//    private Button mButton;
//    private Button  mButton1;
//    private ProgressBar mProgressBar;


        public common123() {
            super();
        }


        @Override
        protected String doInBackground(String... strings) {
             Log.v("TAG","doInBackground");
             int a=0;
             int b=2;

             while (a<99) {
                 a+=b;
                 publishProgress(a);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

             }
            return "ceshi123456";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
             Log.v("TAG","onPreExecute");
             mTextView1.setText("准备开始下载了..");
             mButton.setText("正在下载");

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
             Log.v("TAG","onPostExecute");
            mButton.setText("下载已完成");
            mTextView1.setText(s);

        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
             Log.v("TAG","onPostExecute");
             mProgressBar.setProgress(values[0]);
        }
        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
             Log.v("TAG","onCancelled");
             mButton.setText("已经取消");
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.v("TAG","onCancelled");
            mButton.setText("已经取消123");
        }


    }






    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView1=(TextView) findViewById(R.id.text123);
        mButton=(Button) findViewById(R.id.button);
        mButton1=(Button) findViewById(R.id.button2);
        mProgressBar=(ProgressBar) findViewById(R.id.progressBar);
        //Service.class自定义继承的服务类
//
        Intent intent=new Intent(this,Myservice.class);
        startService(intent);


        final common123 name=new common123();
        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
//                        name.execute("456789");


        			}

        		});
        mButton1.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				name.cancel(true);

        			}

        		});



    }





}


