package cn.feng.news.service;

import cn.feng.news.proto.SmsProto;
import cn.feng.news.proto.SmsServiceGrpc;
import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;

/**
 * @author feng
 * @date 2023/3/28 23:32
 * @email:dujiafeng@gyyx.com
 * @description:
 */
public class SmsService extends SmsServiceGrpc.SmsServiceImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void sendSms(SmsProto.SmsRequest request, StreamObserver<SmsProto.SmsResponse> responseObserver) {
        ProtocolStringList phoneNumberList = request.getPhoneNumberList();
        for (String phoneNumber : phoneNumberList) {
            SmsProto.SmsResponse smsResponse = SmsProto.SmsResponse
                    .newBuilder()
                    .setResult(phoneNumber+"-> "+ request.getContent() + " :success")
                    .build();
            responseObserver.onNext(smsResponse);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        responseObserver.onCompleted();
    }

    /**
     * @param responseObserver
     */
    @Override
    public StreamObserver<SmsProto.PhoneNumberRequest> createPhone(StreamObserver<SmsProto.PhoneNumberResponse> responseObserver) {
        /**
         * 异步通信基于responseObserver的回调
         */
        return new StreamObserver<SmsProto.PhoneNumberRequest>(){
            int i = 0;

            /**
             * 接收到客户端新发来的电话号码时
             * @param phoneNumberRequest
             */
            @Override
            public void onNext(SmsProto.PhoneNumberRequest phoneNumberRequest) {
                System.out.println(phoneNumberRequest.getPhoneNumber()+"手机号已经登记!");
                i++;
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            /**
             * 客户端传输完毕时，完成消息统计
             */
            @Override
            public void onCompleted() {
                SmsProto.PhoneNumberResponse response = SmsProto.PhoneNumberResponse.newBuilder().setResult("您本次批量导入" + i + "个员工电话!").build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * 双向流式
     * @param responseObserver
     */
    @Override
    public StreamObserver<SmsProto.PhoneNumberRequest> createPhoneAndSend(StreamObserver<SmsProto.PhoneNumberResponse> responseObserver) {
        return new StreamObserver<SmsProto.PhoneNumberRequest>(){
            int i = 0;

            /**
             * 接收到客户端新发来的电话号码时
             * @param phoneNumberRequest
             */
            @Override
            public void onNext(SmsProto.PhoneNumberRequest phoneNumberRequest) {
                System.out.println(phoneNumberRequest.getPhoneNumber()+"手机号已经登记!");
                responseObserver.onNext(SmsProto.PhoneNumberResponse.newBuilder().setResult("发送给组长！").build());
                responseObserver.onNext(SmsProto.PhoneNumberResponse.newBuilder().setResult("发送给部门经理！").build());
                responseObserver.onNext(SmsProto.PhoneNumberResponse.newBuilder().setResult("发送给产品！").build());
                i++;
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            /**
             * 客户端传输完毕时，完成消息统计
             */
            @Override
            public void onCompleted() {
                SmsProto.PhoneNumberResponse response = SmsProto.PhoneNumberResponse.newBuilder().setResult("您本次批量导入" + i + "个员工电话!").build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
