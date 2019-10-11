package com.example.grpcservicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dawson.grpc.ReqAndRes;
import com.dawson.grpc.UserServiceGrpc;

import java.nio.channels.Channel;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class MainActivity extends AppCompatActivity {
    final ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BT1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
//                requestServerStream();
//                requestClientStream();
//                requestBothStream();
            }
        });
        init();
    }

    io.grpc.Channel channel;

    private void init() {
        try {
            channel = (io.grpc.Channel) ManagedChannelBuilder.forAddress("192.168.10.187", 6655)
                    .usePlaintext()
                    .build();
        } catch (Exception ex) {
            showRes(ex.getMessage());
        }
    }

    private void request() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ReqAndRes.ReqInfo info = ReqAndRes.ReqInfo.newBuilder().setMsg("hello servercccc").build();
                    UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
                    ReqAndRes.ResInfo res = stub.request(info);
                    showRes(String.valueOf(res.getMsg()));
                } catch (Exception ex) {
                    showRes(ex.getMessage());
                }
            }
        });
    }

    private void requestServerStream() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ReqAndRes.ReqInfo info = ReqAndRes.ReqInfo.newBuilder().setMsg("hello server").build();
                    UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
                    Iterator<ReqAndRes.ResInfo> ress = stub.requestServerStream(info);
                    while (ress.hasNext()) {
                        showRes(String.valueOf(ress.next().getMsg()));
                    }
                } catch (Exception ex) {
                    showRes(ex.getMessage());
                }
            }
        });
    }

    private void requestClientStream() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ReqAndRes.ReqInfo reqInfo1 = ReqAndRes.ReqInfo.newBuilder().setMsg("hello server 1").build();
                    ReqAndRes.ReqInfo reqInfo2 = ReqAndRes.ReqInfo.newBuilder().setMsg("hello server 2").build();
                    UserServiceGrpc.UserServiceStub stub = UserServiceGrpc.newStub(channel);
                    StreamObserver<ReqAndRes.ResInfo> response = new StreamObserver<ReqAndRes.ResInfo>() {
                        @Override
                        public void onNext(ReqAndRes.ResInfo resInfo) {
                            showRes(String.valueOf(resInfo.getMsg()));
                        }

                        @Override
                        public void onError(Throwable t) {
                            showRes(t.getMessage());
                        }

                        @Override
                        public void onCompleted() {
                            showRes("onCompleted");
                        }
                    };

                    StreamObserver<ReqAndRes.ReqInfo> request = stub.requestClientStream(response);
                    request.onNext(reqInfo1);
                    request.onNext(reqInfo2);
                    request.onCompleted();
                } catch (Exception ex) {
                    showRes(ex.getMessage());
                }
            }
        });
    }

    private Thread bsThread;
    StreamObserver<ReqAndRes.ReqInfo> request;

    private void requestBothStream() {
        if (bsThread == null || request == null) {
            bsThread = new Thread() {
                @Override
                public void run() {
                    try {
                        UserServiceGrpc.UserServiceStub stub = UserServiceGrpc.newStub(channel);
                        StreamObserver<ReqAndRes.ResInfo> response = new StreamObserver<ReqAndRes.ResInfo>() {
                            @Override
                            public void onNext(ReqAndRes.ResInfo res) {
                                showRes(String.valueOf(res.getMsg()));
                            }

                            @Override
                            public void onError(Throwable t) {
                                showRes(t.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                showRes("onCompleted");
                            }
                        };
                        request = stub.requestBothStream(response);
                    } catch (Exception ex) {
                        showRes(ex.getMessage());
                    }
                }
            };
            bsThread.start();
        }

        if (bsThread == null || request == null) {
            return;
        }
        ReqAndRes.ReqInfo info = ReqAndRes.ReqInfo.newBuilder().setMsg("hello server" + System.currentTimeMillis() % 1000).build();
        request.onNext(info);
    }

    private void showRes(final String msg) {
//        Log.e("show_res", msg);
         Log.v("TAG",msg);

    }


}

