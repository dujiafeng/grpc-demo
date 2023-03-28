package cn.feng.news;

import cn.feng.news.proto.NewsProto;
import cn.feng.news.proto.NewsServiceGrpc;
import cn.feng.news.proto.SmsProto;
import cn.feng.news.proto.SmsServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
import java.util.List;

/**
 * @author feng
 * @date 2023/3/28 23:39
 * @email:dujiafeng@gyyx.com
 * @description: 服务端RPC流式通信
 */
public class SendSmsClient {
    private static final String HOST = "localhost";
    private static final int SERVERPORT = 9999;

    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, SERVERPORT).usePlaintext()
                // 无需加载认证
                .build();
        try {
            /*BlockingStub支持服务端推流*/
            SmsServiceGrpc.SmsServiceBlockingStub smsServiceBlockingStub = SmsServiceGrpc.newBlockingStub(channel);
            /*传入参数，服务器推流在客户端使用迭代器接收*/
            SmsProto.SmsRequest request = SmsProto.SmsRequest.newBuilder().setContent("下午三点开会")
                    .addPhoneNumber("110")
                    .addPhoneNumber("112")
                    .addPhoneNumber("119").build();
            Iterator<SmsProto.SmsResponse> itr = smsServiceBlockingStub.sendSms(request);
            while (itr.hasNext()){
                SmsProto.SmsResponse next = itr.next();
                System.out.println(next.getResult());
            }
        }finally {
            channel.shutdown();
        }
    }
}
