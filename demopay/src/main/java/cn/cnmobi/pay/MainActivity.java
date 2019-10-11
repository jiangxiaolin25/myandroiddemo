package cn.cnmobi.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button) findViewById(R.id.entersubclass);
        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
                        Intent intent=new Intent(MainActivity.this, subclassmainactivity.class);
                        intent.setAction("android.intent.action.subclass");
                        intent.addCategory("android.intent.category.LAUNCHER");
                        startActivity(intent);


        			}

        		});
    }
}
