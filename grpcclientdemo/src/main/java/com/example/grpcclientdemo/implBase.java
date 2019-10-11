package com.example.grpcclientdemo;


import com.dawson.grpc.ReqAndRes;
import com.dawson.grpc.UserServiceGrpc;

import io.grpc.stub.StreamObserver;

public class implBase extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void request(ReqAndRes.ReqInfo request, StreamObserver<ReqAndRes.ResInfo> responseObserver) {
        ReqAndRes.ResInfo res = ReqAndRes.ResInfo.newBuilder().setMsg("hello clientssssss").build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void requestServerStream(ReqAndRes.ReqInfo request, StreamObserver<ReqAndRes.ResInfo> responseObserver) {

        ReqAndRes.ResInfo res1 = ReqAndRes.ResInfo.newBuilder().setMsg("hello client 1").build();
        ReqAndRes.ResInfo res2 = ReqAndRes.ResInfo.newBuilder().setMsg("hello client 1").build();
        responseObserver.onNext(res1);
        responseObserver.onNext(res2);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ReqAndRes.ReqInfo> requestClientStream(final StreamObserver<ReqAndRes.ResInfo> responseObserver) {

        return new StreamObserver<ReqAndRes.ReqInfo>() {
            StringBuilder stringBuilder = new StringBuilder();

            @Override
            public void onNext(ReqAndRes.ReqInfo res) {
                stringBuilder.append(res.getMsg());
                stringBuilder.append(",");
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                ReqAndRes.ResInfo resInfo = ReqAndRes.ResInfo.newBuilder().setMsg("hello client (" + stringBuilder.toString() + ")")
                        .build();
                responseObserver.onNext(resInfo);
                responseObserver.onCompleted();
            }

        };
    }

    @Override
    public StreamObserver<ReqAndRes.ReqInfo> requestBothStream(final StreamObserver<ReqAndRes.ResInfo> responseObserver) {
        Thread backThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ReqAndRes.ResInfo res = ReqAndRes.ResInfo.newBuilder().setMsg("hello client:" + System.currentTimeMillis() % 1000)
                            .build();
                    responseObserver.onNext(res);
                }

            }
        });
        backThread.start();

        return new StreamObserver<ReqAndRes.ReqInfo>() {
            @Override
            public void onNext(ReqAndRes.ReqInfo value) {
                ReqAndRes.ResInfo.Builder res = ReqAndRes.ResInfo.newBuilder().setMsg("hello client (" + value.getMsg() + ")");
                responseObserver.onNext(res.build());
            }




            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }

}