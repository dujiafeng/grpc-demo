package cn.feng.news;

import cn.feng.news.proto.NewsProto;
import cn.feng.news.proto.NewsServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;

import java.util.List;

/**
 * @author feng
 * @date 2023/3/28 22:32
 * @email:dujiafeng@gyyx.com
 * @description: gRPC启动类
 */
public class NewsClient {

    private static final String HOST = "localhost";
    private static final int SERVERPORT = 9999;

    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, SERVERPORT).usePlaintext()
                // 无需加载认证
                .build();
        try {
            NewsServiceGrpc.NewsServiceBlockingStub blockingStub = NewsServiceGrpc.newBlockingStub(channel);
            NewsProto.NewsRequest request = NewsProto.NewsRequest.newBuilder().setDate("20230101").build();
            NewsProto.NewsResponse response = blockingStub.list(request);
            List<NewsProto.News> newsList = response.getNewsList();
            for (NewsProto.News news : newsList) {
                System.out.println(news.getTitle()+" : "+news.getContent());
            }
        }finally {
            channel.shutdown();
        }
    }
}
