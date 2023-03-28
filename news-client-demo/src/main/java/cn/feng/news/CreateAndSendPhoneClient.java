package cn.feng.news;

import cn.feng.news.proto.SmsProto;
import cn.feng.news.proto.SmsServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author feng
 * @date 2023/3/29 0:05
 * @email:dujiafeng@gyyx.com
 * @description: RPC双向流式通信
 */
public class CreateAndSendPhoneClient {
    private SmsServiceGrpc.SmsServiceStub asyncStub = null;
    private static final String HOST = "localhost";
    private static final int SERVERPORT = 9999;

    public static void main(String[] args) {
        CreateAndSendPhoneClient client = new CreateAndSendPhoneClient();
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, SERVERPORT).usePlaintext().build();

        // 客户端流式RPC通信必须使用异步Stub实现
        client.asyncStub = SmsServiceGrpc.newStub(channel);
        try{
            client.createPhone();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void createPhone() throws InterruptedException{
        // 实例化RequestObject，对应创建10个请求
        StreamObserver<SmsProto.PhoneNumberRequest> requestObserver = asyncStub.createPhoneAndSend(responseObserver);
        for (int i = 0; i < 10; i++) {
            //创建请求对象
            SmsProto.PhoneNumberRequest request = SmsProto.PhoneNumberRequest.newBuilder().setPhoneNumber("1399071345"+i).build();
            //发送请求
            requestObserver.onNext(request);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                requestObserver.onError(e);
                throw e;
            }

        }
        //通知服务器，所有请求都发完了
        requestObserver.onCompleted();
        Thread.sleep(1000);


    }

    /**
     * 监听服务器返回的响应
     */
    StreamObserver<SmsProto.PhoneNumberResponse> responseObserver = new StreamObserver<SmsProto.PhoneNumberResponse>() {

        @Override
        public void onNext(SmsProto.PhoneNumberResponse phoneNumberResponse) {
            System.out.println(phoneNumberResponse.getResult());
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onCompleted() {
            System.out.println("处理完毕！");
        }
    };

}
