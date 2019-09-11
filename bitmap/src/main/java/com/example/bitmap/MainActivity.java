package com.example.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.appcompat.app.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
     private Button mButton;
     private TextView mView;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button) findViewById(R.id.BT1);
        mView=(TextView) findViewById(R.id.TV1);
        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
                        captureScreen();
        			}
        		});
    }
    public void captureScreen() {
        Runnable action = new Runnable() {
            @Override
            public void run() {
                ByteArrayOutputStream byteOut = null;
                //获取的是顶级视图，但是不包括状态栏
                final View contentView = getWindow().getDecorView();
                try{
                    Log.e("HEHE",contentView.getHeight()+":"+contentView.getWidth());
                    bitmap = Bitmap.createBitmap(contentView.getWidth(),
                            contentView.getHeight(), Bitmap.Config.ARGB_4444);
                    contentView.draw(new Canvas(bitmap));
                     byteOut = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteOut);
                    savePic(bitmap, "sdcard/short.png");
                }catch (Exception e){e.printStackTrace();}
                finally {
                    try{
                        if (null != byteOut){
                            byteOut.close();
                        }
                        if (null != bitmap && !bitmap.isRecycled()) {
//                            bitmap.recycle();
                            bitmap = null;
                        }
                    }catch (IOException e){e.printStackTrace();}
                }
            }
        };
        try {
            action.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePic(Bitmap b, String strFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            if (null != fos) {
                boolean success= b.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
                if(success)
                    Toast.makeText(MainActivity.this, "截屏成功", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
