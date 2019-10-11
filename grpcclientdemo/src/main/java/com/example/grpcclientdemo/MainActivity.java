package com.example.grpcclientdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


import com.dawson.grpc.UserServiceGrpc;

import io.grpc.ServerBuilder;

public class MainActivity extends AppCompatActivity {
     private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button) findViewById(R.id.SBT1);
        mButton.setOnClickListener(new Button.OnClickListener() {

        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
                        UserServiceGrpc.UserServiceImplBase userService = new implBase();
                        io.grpc.Server server = ServerBuilder.forPort(6655).addService(userService.bindService()).build();
                        try {
                            server.start();
                            System.out.println("Server start success on port:6655");
                            server.awaitTermination();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

        			}

        		});
    }
}
