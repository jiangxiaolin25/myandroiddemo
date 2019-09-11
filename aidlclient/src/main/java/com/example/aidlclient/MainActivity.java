package com.example.aidlclient;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.jiangxiaolin.myapplication.IMyAidlInterface;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    private IMyAidlInterface mIMyAidlInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.bT2);
        mTextView = (TextView) findViewById(R.id.tx2);


    }
}
