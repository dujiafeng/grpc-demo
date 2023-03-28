package cn.feng.news.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: sms.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SmsServiceGrpc {

  private SmsServiceGrpc() {}

  public static final String SERVICE_NAME = "sms.SmsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<SmsProto.SmsRequest,
      SmsProto.SmsResponse> getSendSmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendSms",
      requestType = SmsProto.SmsRequest.class,
      responseType = SmsProto.SmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<SmsProto.SmsRequest,
      SmsProto.SmsResponse> getSendSmsMethod() {
    io.grpc.MethodDescriptor<SmsProto.SmsRequest, SmsProto.SmsResponse> getSendSmsMethod;
    if ((getSendSmsMethod = SmsServiceGrpc.getSendSmsMethod) == null) {
      synchronized (SmsServiceGrpc.class) {
        if ((getSendSmsMethod = SmsServiceGrpc.getSendSmsMethod) == null) {
          SmsServiceGrpc.getSendSmsMethod = getSendSmsMethod =
              io.grpc.MethodDescriptor.<SmsProto.SmsRequest, SmsProto.SmsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendSms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmsProto.SmsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmsProto.SmsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmsServiceMethodDescriptorSupplier("sendSms"))
              .build();
        }
      }
    }
    return getSendSmsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SmsProto.PhoneNumberRequest,
      SmsProto.PhoneNumberResponse> getCreatePhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createPhone",
      requestType = SmsProto.PhoneNumberRequest.class,
      responseType = SmsProto.PhoneNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<SmsProto.PhoneNumberRequest,
      SmsProto.PhoneNumberResponse> getCreatePhoneMethod() {
    io.grpc.MethodDescriptor<SmsProto.PhoneNumberRequest, SmsProto.PhoneNumberResponse> getCreatePhoneMethod;
    if ((getCreatePhoneMethod = SmsServiceGrpc.getCreatePhoneMethod) == null) {
      synchronized (SmsServiceGrpc.class) {
        if ((getCreatePhoneMethod = SmsServiceGrpc.getCreatePhoneMethod) == null) {
          SmsServiceGrpc.getCreatePhoneMethod = getCreatePhoneMethod =
              io.grpc.MethodDescriptor.<SmsProto.PhoneNumberRequest, SmsProto.PhoneNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createPhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmsProto.PhoneNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmsProto.PhoneNumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmsServiceMethodDescriptorSupplier("createPhone"))
              .build();
        }
      }
    }
    return getCreatePhoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SmsProto.PhoneNumberRequest,
      SmsProto.PhoneNumberResponse> getCreatePhoneAndSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createPhoneAndSend",
      requestType = SmsProto.PhoneNumberRequest.class,
      responseType = SmsProto.PhoneNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<SmsProto.PhoneNumberRequest,
      SmsProto.PhoneNumberResponse> getCreatePhoneAndSendMethod() {
    io.grpc.MethodDescriptor<SmsProto.PhoneNumberRequest, SmsProto.PhoneNumberResponse> getCreatePhoneAndSendMethod;
    if ((getCreatePhoneAndSendMethod = SmsServiceGrpc.getCreatePhoneAndSendMethod) == null) {
      synchronized (SmsServiceGrpc.class) {
        if ((getCreatePhoneAndSendMethod = SmsServiceGrpc.getCreatePhoneAndSendMethod) == null) {
          SmsServiceGrpc.getCreatePhoneAndSendMethod = getCreatePhoneAndSendMethod =
              io.grpc.MethodDescriptor.<SmsProto.PhoneNumberRequest, SmsProto.PhoneNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createPhoneAndSend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmsProto.PhoneNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SmsProto.PhoneNumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmsServiceMethodDescriptorSupplier("createPhoneAndSend"))
              .build();
        }
      }
    }
    return getCreatePhoneAndSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmsServiceStub>() {
        @Override
        public SmsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmsServiceStub(channel, callOptions);
        }
      };
    return SmsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmsServiceBlockingStub>() {
        @Override
        public SmsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmsServiceBlockingStub(channel, callOptions);
        }
      };
    return SmsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmsServiceFutureStub>() {
        @Override
        public SmsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmsServiceFutureStub(channel, callOptions);
        }
      };
    return SmsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SmsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendSms(SmsProto.SmsRequest request,
                        io.grpc.stub.StreamObserver<SmsProto.SmsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendSmsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<SmsProto.PhoneNumberRequest> createPhone(
        io.grpc.stub.StreamObserver<SmsProto.PhoneNumberResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCreatePhoneMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<SmsProto.PhoneNumberRequest> createPhoneAndSend(
        io.grpc.stub.StreamObserver<SmsProto.PhoneNumberResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCreatePhoneAndSendMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendSmsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                SmsProto.SmsRequest,
                SmsProto.SmsResponse>(
                  this, METHODID_SEND_SMS)))
          .addMethod(
            getCreatePhoneMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                SmsProto.PhoneNumberRequest,
                SmsProto.PhoneNumberResponse>(
                  this, METHODID_CREATE_PHONE)))
          .addMethod(
            getCreatePhoneAndSendMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                SmsProto.PhoneNumberRequest,
                SmsProto.PhoneNumberResponse>(
                  this, METHODID_CREATE_PHONE_AND_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class SmsServiceStub extends io.grpc.stub.AbstractAsyncStub<SmsServiceStub> {
    private SmsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SmsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmsServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendSms(SmsProto.SmsRequest request,
                        io.grpc.stub.StreamObserver<SmsProto.SmsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendSmsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<SmsProto.PhoneNumberRequest> createPhone(
        io.grpc.stub.StreamObserver<SmsProto.PhoneNumberResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCreatePhoneMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<SmsProto.PhoneNumberRequest> createPhoneAndSend(
        io.grpc.stub.StreamObserver<SmsProto.PhoneNumberResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCreatePhoneAndSendMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SmsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SmsServiceBlockingStub> {
    private SmsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SmsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<SmsProto.SmsResponse> sendSms(
        SmsProto.SmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendSmsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SmsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SmsServiceFutureStub> {
    private SmsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SmsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_SMS = 0;
  private static final int METHODID_CREATE_PHONE = 1;
  private static final int METHODID_CREATE_PHONE_AND_SEND = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_SMS:
          serviceImpl.sendSms((SmsProto.SmsRequest) request,
              (io.grpc.stub.StreamObserver<SmsProto.SmsResponse>) responseObserver);
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
        case METHODID_CREATE_PHONE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createPhone(
              (io.grpc.stub.StreamObserver<SmsProto.PhoneNumberResponse>) responseObserver);
        case METHODID_CREATE_PHONE_AND_SEND:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createPhoneAndSend(
              (io.grpc.stub.StreamObserver<SmsProto.PhoneNumberResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmsServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SmsProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmsService");
    }
  }

  private static final class SmsServiceFileDescriptorSupplier
      extends SmsServiceBaseDescriptorSupplier {
    SmsServiceFileDescriptorSupplier() {}
  }

  private static final class SmsServiceMethodDescriptorSupplier
      extends SmsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SmsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmsServiceFileDescriptorSupplier())
              .addMethod(getSendSmsMethod())
              .addMethod(getCreatePhoneMethod())
              .addMethod(getCreatePhoneAndSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
