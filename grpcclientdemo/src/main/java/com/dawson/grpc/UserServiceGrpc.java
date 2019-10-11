package com.dawson.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: ReqAndRes.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getRequestMethod()} instead.
  public static final io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> METHOD_REQUEST = getRequestMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestMethod() {
    return getRequestMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestMethodHelper() {
    io.grpc.MethodDescriptor<ReqAndRes.ReqInfo, ReqAndRes.ResInfo> getRequestMethod;
    if ((getRequestMethod = UserServiceGrpc.getRequestMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRequestMethod = UserServiceGrpc.getRequestMethod) == null) {
          UserServiceGrpc.getRequestMethod = getRequestMethod = 
              io.grpc.MethodDescriptor.<ReqAndRes.ReqInfo, ReqAndRes.ResInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "request"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ReqInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ResInfo.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getRequestMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getRequestServerStreamMethod()} instead.
  public static final io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> METHOD_REQUEST_SERVER_STREAM = getRequestServerStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestServerStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestServerStreamMethod() {
    return getRequestServerStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestServerStreamMethodHelper() {
    io.grpc.MethodDescriptor<ReqAndRes.ReqInfo, ReqAndRes.ResInfo> getRequestServerStreamMethod;
    if ((getRequestServerStreamMethod = UserServiceGrpc.getRequestServerStreamMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRequestServerStreamMethod = UserServiceGrpc.getRequestServerStreamMethod) == null) {
          UserServiceGrpc.getRequestServerStreamMethod = getRequestServerStreamMethod = 
              io.grpc.MethodDescriptor.<ReqAndRes.ReqInfo, ReqAndRes.ResInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "requestServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ReqInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ResInfo.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getRequestServerStreamMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getRequestClientStreamMethod()} instead.
  public static final io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> METHOD_REQUEST_CLIENT_STREAM = getRequestClientStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestClientStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestClientStreamMethod() {
    return getRequestClientStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestClientStreamMethodHelper() {
    io.grpc.MethodDescriptor<ReqAndRes.ReqInfo, ReqAndRes.ResInfo> getRequestClientStreamMethod;
    if ((getRequestClientStreamMethod = UserServiceGrpc.getRequestClientStreamMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRequestClientStreamMethod = UserServiceGrpc.getRequestClientStreamMethod) == null) {
          UserServiceGrpc.getRequestClientStreamMethod = getRequestClientStreamMethod = 
              io.grpc.MethodDescriptor.<ReqAndRes.ReqInfo, ReqAndRes.ResInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "requestClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ReqInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ResInfo.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getRequestClientStreamMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getRequestBothStreamMethod()} instead.
  public static final io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> METHOD_REQUEST_BOTH_STREAM = getRequestBothStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestBothStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestBothStreamMethod() {
    return getRequestBothStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ReqAndRes.ReqInfo,
      ReqAndRes.ResInfo> getRequestBothStreamMethodHelper() {
    io.grpc.MethodDescriptor<ReqAndRes.ReqInfo, ReqAndRes.ResInfo> getRequestBothStreamMethod;
    if ((getRequestBothStreamMethod = UserServiceGrpc.getRequestBothStreamMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRequestBothStreamMethod = UserServiceGrpc.getRequestBothStreamMethod) == null) {
          UserServiceGrpc.getRequestBothStreamMethod = getRequestBothStreamMethod = 
              io.grpc.MethodDescriptor.<ReqAndRes.ReqInfo, ReqAndRes.ResInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "UserService", "requestBothStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ReqInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  ReqAndRes.ResInfo.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getRequestBothStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void request(ReqAndRes.ReqInfo request,
                        io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestMethodHelper(), responseObserver);
    }

    /**
     */
    public void requestServerStream(ReqAndRes.ReqInfo request,
                                    io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestServerStreamMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ReqAndRes.ReqInfo> requestClientStream(
        io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      return asyncUnimplementedStreamingCall(getRequestClientStreamMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ReqAndRes.ReqInfo> requestBothStream(
        io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      return asyncUnimplementedStreamingCall(getRequestBothStreamMethodHelper(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ReqAndRes.ReqInfo,
                ReqAndRes.ResInfo>(
                  this, METHODID_REQUEST)))
          .addMethod(
            getRequestServerStreamMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ReqAndRes.ReqInfo,
                ReqAndRes.ResInfo>(
                  this, METHODID_REQUEST_SERVER_STREAM)))
          .addMethod(
            getRequestClientStreamMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ReqAndRes.ReqInfo,
                ReqAndRes.ResInfo>(
                  this, METHODID_REQUEST_CLIENT_STREAM)))
          .addMethod(
            getRequestBothStreamMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ReqAndRes.ReqInfo,
                ReqAndRes.ResInfo>(
                  this, METHODID_REQUEST_BOTH_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void request(ReqAndRes.ReqInfo request,
                        io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestServerStream(ReqAndRes.ReqInfo request,
                                    io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRequestServerStreamMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ReqAndRes.ReqInfo> requestClientStream(
        io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRequestClientStreamMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ReqAndRes.ReqInfo> requestBothStream(
        io.grpc.stub.StreamObserver<ReqAndRes.ResInfo> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRequestBothStreamMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ReqAndRes.ResInfo request(ReqAndRes.ReqInfo request) {
      return blockingUnaryCall(
          getChannel(), getRequestMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ReqAndRes.ResInfo> requestServerStream(
        ReqAndRes.ReqInfo request) {
      return blockingServerStreamingCall(
          getChannel(), getRequestServerStreamMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ReqAndRes.ResInfo> request(
        ReqAndRes.ReqInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST = 0;
  private static final int METHODID_REQUEST_SERVER_STREAM = 1;
  private static final int METHODID_REQUEST_CLIENT_STREAM = 2;
  private static final int METHODID_REQUEST_BOTH_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST:
          serviceImpl.request((ReqAndRes.ReqInfo) request,
              (io.grpc.stub.StreamObserver<ReqAndRes.ResInfo>) responseObserver);
          break;
        case METHODID_REQUEST_SERVER_STREAM:
          serviceImpl.requestServerStream((ReqAndRes.ReqInfo) request,
              (io.grpc.stub.StreamObserver<ReqAndRes.ResInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.requestClientStream(
              (io.grpc.stub.StreamObserver<ReqAndRes.ResInfo>) responseObserver);
        case METHODID_REQUEST_BOTH_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.requestBothStream(
              (io.grpc.stub.StreamObserver<ReqAndRes.ResInfo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getRequestMethodHelper())
              .addMethod(getRequestServerStreamMethodHelper())
              .addMethod(getRequestClientStreamMethodHelper())
              .addMethod(getRequestBothStreamMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
