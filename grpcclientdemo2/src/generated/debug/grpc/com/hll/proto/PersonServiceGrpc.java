package com.hll.proto;

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
 * <pre>
 *rpc方法
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: grpc.proto")
public final class PersonServiceGrpc {

  private PersonServiceGrpc() {}

  public static final String SERVICE_NAME = "com.hll.proto.PersonService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRealNameByUsernameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.hll.proto.MyRequest,
      com.hll.proto.MyResponse> METHOD_GET_REAL_NAME_BY_USERNAME = getGetRealNameByUsernameMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.hll.proto.MyRequest,
      com.hll.proto.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.hll.proto.MyRequest,
      com.hll.proto.MyResponse> getGetRealNameByUsernameMethod() {
    return getGetRealNameByUsernameMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.hll.proto.MyRequest,
      com.hll.proto.MyResponse> getGetRealNameByUsernameMethodHelper() {
    io.grpc.MethodDescriptor<com.hll.proto.MyRequest, com.hll.proto.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = PersonServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = PersonServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          PersonServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod = 
              io.grpc.MethodDescriptor.<com.hll.proto.MyRequest, com.hll.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.hll.proto.PersonService", "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.hll.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.hll.proto.MyResponse.getDefaultInstance()))
                  .build();
          }
        }
     }
     return getGetRealNameByUsernameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonServiceStub newStub(io.grpc.Channel channel) {
    return new PersonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonServiceFutureStub(channel);
  }

  /**
   * <pre>
   *rpc方法
   * </pre>
   */
  public static abstract class PersonServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUsername(com.hll.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.hll.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.hll.proto.MyRequest,
                com.hll.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .build();
    }
  }

  /**
   * <pre>
   *rpc方法
   * </pre>
   */
  public static final class PersonServiceStub extends io.grpc.stub.AbstractStub<PersonServiceStub> {
    private PersonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUsername(com.hll.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.hll.proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *rpc方法
   * </pre>
   */
  public static final class PersonServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonServiceBlockingStub> {
    private PersonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.hll.proto.MyResponse getRealNameByUsername(com.hll.proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *rpc方法
   * </pre>
   */
  public static final class PersonServiceFutureStub extends io.grpc.stub.AbstractStub<PersonServiceFutureStub> {
    private PersonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.hll.proto.MyResponse> getRealNameByUsername(
        com.hll.proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((com.hll.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.hll.proto.MyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGetRealNameByUsernameMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
